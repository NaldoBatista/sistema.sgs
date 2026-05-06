package com.example.sgs.repository;

import com.example.sgs.infrastructure.ConexaoDB;
import com.example.sgs.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private final Connection conn;

    public CategoriaDAO() {
        conn = ConexaoDB.getConnection();
    }

    public List<Categoria> findAll() throws SQLException {
        List<Categoria> categoriaList = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()
        ) {
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setNome(resultSet.getString("nome"));

                categoriaList.add(categoria);
            }
        }

        return categoriaList;
    }
}
