package dev.proje.Organizados.DTO;

import jakarta.validation.constraints.NotBlank;

public class UserUpdatePasswordDTO {
    @NotBlank
    private String senhaAtual;
    @NotBlank(message = "Senha é obrigatória")
    private String novaSenha;

    public UserUpdatePasswordDTO() {
    }

    public UserUpdatePasswordDTO(String novaSenha) {
        this.setNovaSenha(novaSenha);
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
