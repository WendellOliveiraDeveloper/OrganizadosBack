package dev.proje.Organizados.Exceptions;

public class InvalidPassword extends RuntimeException {
    public InvalidPassword() {
        super("Senha inválida");
    }
}
