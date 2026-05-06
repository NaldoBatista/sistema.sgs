package com.example.sgs.busines;

import com.example.sgs.model.Solicitante;
import com.example.sgs.repository.SolicitanteDAO;

import java.sql.SQLException;
import java.util.List;

public class SolicitanteService {
    final private SolicitanteDAO solicitanteDAO;

    public SolicitanteService() throws SQLException {
        this.solicitanteDAO = new SolicitanteDAO();
    }

    public List<Solicitante> consultarSolicitantes() throws SQLException {
        return solicitanteDAO.findAll();
    }
}
