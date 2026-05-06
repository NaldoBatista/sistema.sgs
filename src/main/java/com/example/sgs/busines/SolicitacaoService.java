package com.example.sgs.busines;

import com.example.sgs.model.Solicitacao;
import com.example.sgs.repository.SolicitacaoDAO;

import java.sql.SQLException;
import java.util.List;

public class SolicitacaoService {

    final private SolicitacaoDAO solicitacaoDAO;

    public SolicitacaoService() throws SQLException {
        this.solicitacaoDAO = new SolicitacaoDAO();
    }

    public List<Solicitacao> consultarSolicitacoes() throws SQLException {
        return solicitacaoDAO.findAll();
    }
}
