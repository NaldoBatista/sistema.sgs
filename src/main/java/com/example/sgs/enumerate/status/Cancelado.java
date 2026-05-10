package com.example.sgs.enumerate.status;

import com.example.sgs.exceptions.StatusTransicaoNaoPermitidaException;

public class Cancelado implements StatusSolicitacaoInterface {
    private final int ID = 5;
    private final String DESCRICAO = "CANCELADO";

    @Override
    public int getId() {
        return this.ID;
    }

    @Override
    public String getDescricao() {
        return this.DESCRICAO;
    }

    @Override
    public StatusSolicitacaoInterface transicionarPara(StatusSolicitacaoInterface status) {
        throw new StatusTransicaoNaoPermitidaException("O status " + this.DESCRICAO + " não pode ser alterado");
    }
}
