package com.example.sgs.enumerate.status;

import com.example.sgs.exceptions.StatusTransicaoNaoPermitidaException;

public class Rejeitado implements StatusSolicitacaoInterface {
    private final int ID = 4;
    private final String DESCRICAO = "REJEITADO";

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
