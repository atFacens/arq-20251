package br.facens.projeto01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ProdutoExceptionsHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionDetails> MethodArgumentTypeMismatchExceptionHandler(
            MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.badRequest().body(new ExceptionDetails("Erro nos parâmetros", ex.getMessage()));
    }

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<ExceptionDetails> ProdutoNotFoundExceptionHandler(ProdutoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDetails("Produto não encontrado", ex.getMessage()));
    }

}
