package com.example.sgs.repository;

import com.example.sgs.infrastructure.ConexaoDB;
import com.example.sgs.model.Solicitacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDAO {

    private final Connection conn;

    public SolicitacaoDAO() {
        conn = ConexaoDB.getConnection();
    }

    public List<Solicitacao> findAll() throws SQLException {
        List<Solicitacao> solicitacaoList = new ArrayList<>();
        String sql = "SELECT * FROM solicitacao";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()
        ) {
            while (resultSet.next()) {
                Solicitacao solicitacao = new Solicitacao();
                solicitacao.setId(resultSet.getInt("id"));
                solicitacao.setSolicitanteId(resultSet.getInt("solicitante_id"));
                solicitacao.setCategoriaId(resultSet.getInt("categoria_id"));
                solicitacao.setDescricao(resultSet.getString("descricao"));
                solicitacao.setValor(resultSet.getDouble("valor"));
                solicitacao.setStatus(resultSet.getInt("status"));

                solicitacaoList.add(solicitacao);
            }
        }

        return solicitacaoList;
    }
}
