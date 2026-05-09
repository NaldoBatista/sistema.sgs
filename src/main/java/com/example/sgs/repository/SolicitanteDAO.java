package com.example.sgs.repository;

import com.example.sgs.infrastructure.ConexaoDB;
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
        } catch (SQLException e) {
            throw new SQLException("Falha ao consultar solicitantes!");
        }

        return solicitanteList;
    }
    public Solicitante findById(int solicitanteId) throws SQLException {
        String sql = "SELECT * FROM solicitante WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, solicitanteId);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Solicitante solicitante = new Solicitante();
                solicitante.setId(resultSet.getInt("id"));
                solicitante.setNome(resultSet.getString("nome"));
                solicitante.setCPFOuCNPJ(resultSet.getString("cpf_cnpj"));

                return solicitante;
            } else {
                throw new RuntimeException("Solicitante não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Falha ao consultar categoria!");
        }
    }
}
