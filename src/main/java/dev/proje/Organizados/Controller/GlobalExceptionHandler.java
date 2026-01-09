package dev.proje.Organizados.Controller;

import dev.proje.Organizados.DTO.ApiError;
import dev.proje.Organizados.Exceptions.InvalidPassword;
import dev.proje.Organizados.Exceptions.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ApiError> handleUsuarioNaoEncontrado(UserNotFound ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(InvalidPassword.class)
    public ResponseEntity<ApiError> handleSenhaInvalida(InvalidPassword ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ApiError(ex.getMessage()));
    }
}
