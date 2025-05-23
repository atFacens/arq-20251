package br.facens.projeto01.exceptions;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String msg) {
        super(msg);
    }
}
