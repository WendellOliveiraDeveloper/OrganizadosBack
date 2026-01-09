package dev.proje.Organizados.DTO;

import lombok.extern.java.Log;

public class UserResponseDTO {
    private Long id;
    private String email;
    private String nome;
    private String telefone;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String email, String nome, String telefone) {
        this.setId(id);
        this.setEmail(email);
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
