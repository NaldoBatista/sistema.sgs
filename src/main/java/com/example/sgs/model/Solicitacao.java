package com.example.sgs.model;

import com.example.sgs.enumerate.StatusSolicitacaoEnum;
import com.example.sgs.enumerate.status.StatusSolicitacaoInterface;
import com.example.sgs.repository.CategoriaDAO;
import com.example.sgs.repository.SolicitanteDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solicitacao {

    private Integer id;
    private Integer solicitanteId;
    private Integer categoriaId;
    private String descricao;
    private Double valor;
    private LocalDate dataSolicitacao;
    private Integer statusId;
    private Solicitante solicitante;
    private Categoria categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSolicitanteId(Integer solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Integer getSolicitanteId() {
        return solicitanteId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public String getDataSolicitacaoFormatada() {
        if (dataSolicitacao == null) {
            return "";
        }

        return dataSolicitacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Solicitante getSolicitante() throws SQLException {
        if (solicitante == null) {
            SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
            this.solicitante = solicitanteDAO.findById(getSolicitanteId());
        }

        return this.solicitante;
    }

    public Categoria getCategoria() throws SQLException {
        if (categoria == null) {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoria = categoriaDAO.findById(getCategoriaId());
        }

        return categoria;
    }

    public StatusSolicitacaoInterface getStatus() {
        return StatusSolicitacaoEnum.getStatusById(this.statusId);
    }
}
