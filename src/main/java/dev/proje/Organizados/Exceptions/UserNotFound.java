package dev.proje.Organizados.Exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super("Usuário não encontrado");
    }
}
