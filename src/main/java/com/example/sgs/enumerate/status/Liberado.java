package com.example.sgs.enumerate.status;

import com.example.sgs.exceptions.StatusTransicaoNaoPermitidaException;

public class Liberado implements StatusSolicitacaoInterface {

    private final int ID = 2;
    private final String DESCRICAO = "LIBERADO";

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
        StatusSolicitacaoInterface aprovado = new Aprovado();
        StatusSolicitacaoInterface rejeitado = new Rejeitado();

        if (status.getId() == aprovado.getId()) {
            return aprovado;
        }

        if (status.getId() == rejeitado.getId()) {
            return rejeitado;
        }

        throw new StatusTransicaoNaoPermitidaException(
                "Solicitações com status "
                + this.DESCRICAO
                + " só podem ser movidas para "
                + aprovado.getDescricao()
                + " ou "
                + rejeitado.getDescricao()
                + "."
        );
    }
}
