package dev.proje.Organizados.DTO;

import jakarta.validation.constraints.*;

public class UserCreateDTO {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 4, max = 22, message = "senha deve conter mínimo de 4 caracteres")
    private String senha;
    @NotBlank
    private String nome;
    private String telefone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
