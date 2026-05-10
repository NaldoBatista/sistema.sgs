package com.example.sgs.enumerate.status;

import com.example.sgs.exceptions.StatusTransicaoNaoPermitidaException;

public class Aprovado implements StatusSolicitacaoInterface {

    private final int ID = 1;
    private final String DESCRICAO = "APROVADO";

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
        StatusSolicitacaoInterface cancelado = new Cancelado();

        if (status.getId() == cancelado.getId()) {
            return cancelado;
        }

        throw new StatusTransicaoNaoPermitidaException(
                "Solicitações com status "
                + this.DESCRICAO
                + " só podem ser movidas para "
                + cancelado.getDescricao()
                + "."
        );
    }
}
