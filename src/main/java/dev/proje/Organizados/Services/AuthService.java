package dev.proje.Organizados.Services;

import dev.proje.Organizados.Exceptions.InvalidPassword;
import dev.proje.Organizados.Exceptions.UserNotFound;
import dev.proje.Organizados.Model.UserModel;
import dev.proje.Organizados.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void login(String email, String senha) {
        UserModel user = userRepository
                .findByEmail(email)
                .orElseThrow(
                        UserNotFound::new
                );
        if (!passwordEncoder.matches(senha, user.getSenha())) {
            throw new InvalidPassword();
        }
    }
}
