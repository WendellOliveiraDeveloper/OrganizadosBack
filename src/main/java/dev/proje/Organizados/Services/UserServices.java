package dev.proje.Organizados.Services;

import dev.proje.Organizados.DTO.UserCreateDTO;
import dev.proje.Organizados.DTO.UserResponseDTO;
import dev.proje.Organizados.DTO.UserUpdateDTO;
import dev.proje.Organizados.DTO.UserUpdatePasswordDTO;
import dev.proje.Organizados.Mapper.UserMapper;
import dev.proje.Organizados.Model.UserModel;
import dev.proje.Organizados.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO findById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isPresent()) {
            return userMapper.toDTO(user.get());
        } else {
            return null;
        }
    }

    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        UserModel user = userMapper.toEntity(userCreateDTO);
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        UserModel createdUser = userRepository.save(user);
        return userMapper.toDTO(createdUser);
    }

    public UserResponseDTO updateUser(Long id, UserUpdateDTO usuarioAtualizarDTO) {
        Optional<UserModel> usuarioExistante = userRepository.findById(id);

        if (usuarioExistante.isPresent()) {
            UserModel newDataUser = usuarioExistante.get();
            userMapper.updateEntityFromDTO(newDataUser, usuarioAtualizarDTO);
            UserModel usuarioAtualizado = userRepository.save(newDataUser);

            return userMapper.toDTO(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public UserResponseDTO atualizarSenha(Long id, UserUpdatePasswordDTO usuarioDTO) {
        Optional<UserModel> usuarioExistente = userRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            UserModel novaSenha = usuarioExistente.get();
            userMapper.updatePasswordFromDTO(novaSenha, usuarioDTO);
            UserModel usuarioAtualizado = userRepository.save(novaSenha);

            return userMapper.toDTO(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado para atualizar senha");
        }
    }
}
