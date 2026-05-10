package com.example.sgs.exceptions;

public class StatusTransicaoNaoPermitidaException extends RuntimeException {

    public StatusTransicaoNaoPermitidaException(String mensagem) {
        super(mensagem);
    }
}
