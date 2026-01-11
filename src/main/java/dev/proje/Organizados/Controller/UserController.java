package dev.proje.Organizados.Controller;

import dev.proje.Organizados.DTO.*;
import dev.proje.Organizados.Services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<UserResponseDTO> mostrarUsusarios() {
        return userServices.findAll();
    }

    @GetMapping("dados_user_email/{email}")
    public ResponseEntity<UserResponseDTO> mostrarDadosUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userServices.findByEmail(email));
    }

    @GetMapping("dados_user/{id}")
    public ResponseEntity<UserResponseDTO> mostrarDadosUser(@PathVariable Long id) {
        return ResponseEntity.ok(userServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> criarUser(@Valid @RequestBody UserCreateDTO request) {
        UserResponseDTO userCreateResponse = userServices.createUser(request);
        return ResponseEntity.ok(userCreateResponse);
    }

    @PutMapping("atualizar_user/{id}")
    public ResponseEntity<UserResponseDTO> atualizarUser(@PathVariable Long id,
                                                         @Valid @RequestBody UserUpdateDTO request) {
        UserResponseDTO userAtualizarResponseDTO = userServices.updateUser(id, request);
        return ResponseEntity.ok(userAtualizarResponseDTO);
    }

    @PutMapping("atualizar_senha/{id}")
    public ResponseEntity<UserResponseDTO> atualizarSenha(@PathVariable Long id,
                                                          @Valid @RequestBody UserUpdatePasswordDTO request) {
        UserResponseDTO userResponseDTO = userServices.atualizarSenha(id, request);
        return ResponseEntity.ok(userResponseDTO);
    }
}
