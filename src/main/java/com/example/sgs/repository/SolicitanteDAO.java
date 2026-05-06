package com.example.sgs.repository;

import com.example.sgs.infrastructure.ConexaoDB;
import com.example.sgs.model.Solicitacao;
import com.example.sgs.model.Solicitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitanteDAO {
    private final Connection conn;

    public SolicitanteDAO() {
        conn = ConexaoDB.getConnection();
    }

    public List<Solicitante> findAll() throws SQLException {
        List<Solicitante> solicitanteList = new ArrayList<>();
        String sql = "SELECT * FROM solicitante";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()
        ) {
            while (resultSet.next()) {
                Solicitante solicitante = new Solicitante();
                solicitante.setId(resultSet.getInt("id"));
                solicitante.setNome(resultSet.getString("nome"));
                solicitante.setCPFOuCNPJ(resultSet.getString("cpf_cnpj"));

                solicitanteList.add(solicitante);
            }
        }

        return solicitanteList;
    }
}
