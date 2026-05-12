package com.example.sgs.repository;

import com.example.sgs.exceptions.RegistroNaoEncontradoException;
import com.example.sgs.filters.SolicitacaoFiltros;
import com.example.sgs.infrastructure.ConexaoDB;
import com.example.sgs.model.Solicitacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDAO {

    private final Connection conn;

    public SolicitacaoDAO() {
        conn = ConexaoDB.getConnection();
    }

    public List<Solicitacao> findByFilters(SolicitacaoFiltros solicitacaoFiltros) throws SQLException {
        List<Solicitacao> solicitacaoList = new ArrayList<>();
        List<Object> params = new ArrayList<>();
        String sql = "SELECT * FROM solicitacao WHERE 1=1";

        if (solicitacaoFiltros.hasCategoriaId()) {
            sql += " AND categoria_id = ?";
            params.add(solicitacaoFiltros.getCategoriaId());
        }

        if (solicitacaoFiltros.hasSolicitanteId()) {
            sql += " AND solicitante_id = ?";
            params.add(solicitacaoFiltros.getSolicitanteId());
        }

        if (solicitacaoFiltros.hasDataInicialSolicitacao()) {
            sql += " AND data_solicitacao >= ? ";
            params.add(java.sql.Date.valueOf(solicitacaoFiltros.getDataInicialSolicitacao()));
        }

        if (solicitacaoFiltros.hasDataFinalSolicitacao()) {
            sql += " AND data_solicitacao <= ?";
            params.add(java.sql.Date.valueOf(solicitacaoFiltros.getDataFinalSolicitacao()));
        }

        if (solicitacaoFiltros.hasStatusId()) {
            sql += " AND status_id = ?";
            params.add(solicitacaoFiltros.getStatusId());
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Solicitacao solicitacao = new Solicitacao();
                solicitacao.setId(resultSet.getInt("id"));
                solicitacao.setSolicitanteId(resultSet.getInt("solicitante_id"));
                solicitacao.setCategoriaId(resultSet.getInt("categoria_id"));
                solicitacao.setDescricao(resultSet.getString("descricao"));
                solicitacao.setValor(resultSet.getDouble("valor"));
                solicitacao.setDataSolicitacao(resultSet.getObject("data_solicitacao", LocalDate.class));
                solicitacao.setStatusId(resultSet.getInt("status_id"));

                solicitacaoList.add(solicitacao);
            }
        }

        return solicitacaoList;
    }

    public void save(Solicitacao solicitacao) throws SQLException {
        String sql = """
                    INSERT INTO solicitacao(
                        solicitante_id,
                        categoria_id,
                        descricao,
                        valor,
                        data_solicitacao,
                        status_id
                    ) VALUES(?, ?, ?, ?, ?, ?) 
                    """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, solicitacao.getSolicitanteId());
            stmt.setInt(2, solicitacao.getCategoriaId());
            stmt.setString(3, solicitacao.getDescricao());
            stmt.setDouble(4, solicitacao.getValor());
            stmt.setObject(5, solicitacao.getDataSolicitacao());
            stmt.setInt(6, solicitacao.getStatusId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Falha ao cadastrar solicitação.");
        }
    }

    public Solicitacao findById(int solicitacaoId) throws SQLException {
        String sql = "SELECT * FROM solicitacao WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, solicitacaoId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    Solicitacao solicitacao = new Solicitacao();
                    solicitacao.setId(resultSet.getInt("id"));
                    solicitacao.setSolicitanteId(resultSet.getInt("solicitante_id"));
                    solicitacao.setCategoriaId(resultSet.getInt("categoria_id"));
                    solicitacao.setDescricao(resultSet.getString("descricao"));
                    solicitacao.setValor(resultSet.getDouble("valor"));
                    solicitacao.setDataSolicitacao(resultSet.getObject("data_solicitacao", LocalDate.class));
                    solicitacao.setStatusId(resultSet.getInt("status_id"));

                    return solicitacao;
                } else {
                    throw new RegistroNaoEncontradoException("Solicitação não encontrada: " + solicitacaoId);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Falha ao consultar solicitaçao: " + solicitacaoId);
        }
    }

    public void update(Solicitacao solicitacao) throws SQLException {
        String sql = """
                    UPDATE solicitacao SET
                        solicitante_id = ?,
                        categoria_id = ?,
                        descricao = ?,
                        valor = ?,
                        data_solicitacao = ?,
                        status_id = ?
                    WHERE id = ?
                    """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, solicitacao.getSolicitanteId());
            stmt.setInt(2, solicitacao.getCategoriaId());
            stmt.setString(3, solicitacao.getDescricao());
            stmt.setDouble(4, solicitacao.getValor());
            stmt.setObject(5, solicitacao.getDataSolicitacao());
            stmt.setInt(6, solicitacao.getStatusId());
            stmt.setInt(7, solicitacao.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Falha ao atualizar solicitação. ");
        }
    }

    public void remove(int solcitacaoId) throws SQLException {
        String sql = "DELETE FROM solicitacao WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, solcitacaoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Falha ao remover solicitacao.");
        }
    }
}
