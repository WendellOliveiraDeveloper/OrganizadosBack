package dev.proje.Organizados.Controller;

import dev.proje.Organizados.DTO.UserLoginDTO;
import dev.proje.Organizados.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthLogin {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO request) {
        authService.login(request.getEmail(), request.getSenha());

        return ResponseEntity.ok(Map.of(
                "mensage", "Login realizado!"
        ));
    }
}
