package com.example.sgs.busines;

import com.example.sgs.filtro.SolicitacaoFiltros;
import com.example.sgs.model.Categoria;
import com.example.sgs.repository.CategoriaDAO;

import java.sql.SQLException;
import java.util.List;

public class CategoriaService {
    final private CategoriaDAO categoriaDAO;

    public CategoriaService() throws SQLException {
        this.categoriaDAO = new CategoriaDAO();
    }

    public List<Categoria> consultarCategorias() throws SQLException {
        return categoriaDAO.findAll();
    }
}
