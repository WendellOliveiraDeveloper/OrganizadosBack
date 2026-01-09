package dev.proje.Organizados.Mapper;

import dev.proje.Organizados.DTO.*;
import dev.proje.Organizados.Model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel toEntity(UserCreateDTO dto) {
        if (dto == null) return null;

        UserModel user = new UserModel();

        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());
        user.setTelefone(dto.getTelefone());

        return user;
    }

    public UserResponseDTO userResponseDTO(UserModel user) {
        if (user == null) return null;

        return new UserResponseDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getTelefone()
        );
    }

    public void updateEntityFromDTO(UserModel user, UserUpdateDTO dto) {
        if (user == null || dto == null) return;

        if (dto.getNome() != null && !dto.getNome().trim().isEmpty()) {
            user.setNome(dto.getNome());
        }

        if (dto.getEmail() != null && !dto.getEmail().trim().isEmpty()) {
            user.setNome(dto.getEmail());
        }

        if (dto.getTelefone() != null && !dto.getTelefone().trim().isEmpty()) {
            user.setNome(dto.getTelefone());
        }
    }

    public void updatePasswordFromDTO(UserModel user, UserUpdatePasswordDTO dto) {
        if (user == null || dto == null) return;

        if (dto.getSenhaAtual() != null && !dto.getSenhaAtual().trim().isEmpty()) {
            user.setSenha(dto.getNovaSenha());
        }
    }

    public UserResponseDTO toDTO(UserModel user) {
        if (user == null) return null;

        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getNome(),
                user.getTelefone()
        );
    }

    public UserLoginDTO toLoginDTO(UserModel user) {
        if (user == null) return null;

        return new UserLoginDTO(
                user.getEmail(),
                user.getSenha()
        );
    }
}
