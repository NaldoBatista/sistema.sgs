package com.example.sgs.enumerate.status;

import com.example.sgs.exceptions.StatusTransicaoNaoPermitidaException;

public class Solicitado implements StatusSolicitacaoInterface {
    private final int ID = 3;
    private final String DESCRICAO = "SOLICITADO";

    public int getId() {
        return this.ID;
    }

    @Override
    public String getDescricao() {
        return this.DESCRICAO;
    }

    @Override
    public StatusSolicitacaoInterface transicionarPara(StatusSolicitacaoInterface status) {
        StatusSolicitacaoInterface liberado = new Liberado();
        StatusSolicitacaoInterface rejeitado = new Rejeitado();

        if (status.getId() == liberado.getId()) {
            return liberado;
        }

        if (status.getId() == rejeitado.getId()) {
            return rejeitado;
        }

        throw new StatusTransicaoNaoPermitidaException(
            "Solicitações com status " + this.DESCRICAO +
            " só podem ser movidas para " + rejeitado.getDescricao()
                    + "ou" + liberado.getDescricao()
        );
    }
}
