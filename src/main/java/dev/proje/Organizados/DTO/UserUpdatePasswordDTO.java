package dev.proje.Organizados.DTO;

import jakarta.validation.constraints.NotBlank;

public class UserUpdatePasswordDTO {
    @NotBlank
    private String senhaAtual;
    @NotBlank(message = "Senha é obrigatória")
    private String novaSenha;

    public UserUpdatePasswordDTO() {
    }

    public UserUpdatePasswordDTO(String senhaAtual, String novaSenha) {
        this.setSenhaAtual(senhaAtual);
        this.setNovaSenha(novaSenha);
    }

    public @NotBlank String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
