package com.example.sgs.enumerate.status;

public interface StatusSolicitacaoInterface {
        public int getId();
        public String getDescricao();
        public StatusSolicitacaoInterface transicionarPara(StatusSolicitacaoInterface status);
}
