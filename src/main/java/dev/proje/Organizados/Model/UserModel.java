package dev.proje.Organizados.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.apache.catalina.User;

@Entity
@Table(name = "usuarios")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank
    @Size(min = 4, max = 22, message = "Senha deve conter 4 caracteres no minimo")
    @Column(nullable = false)
    private String senha;
    @NotNull
    private String nome;
    @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$",
            message = "Telefone deve ser preenchido com modelos (xx) xxxxx-xxxx ou (xx) xxxx-xxxx")
    @Column(unique = true)
    private String telefone;

    public UserModel() {
    }

    public UserModel(Long id, String email, String senha, String nome, String telefone) {
        this.setId(id);
        this.setEmail(email);
        this.setSenha(senha);
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank String senha) {
        this.senha = senha;
    }

    public @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotNull String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
