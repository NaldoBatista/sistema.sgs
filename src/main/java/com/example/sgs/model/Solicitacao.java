package com.example.sgs.model;

import java.time.LocalDate;

public class Solicitacao {

    public int id;
    public int solicitanteId;
    public int categoriaId;
    public String descricao;
    public double valor;
    public LocalDate dataSolicitacao;
    public int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSolicitanteId(int solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public int getSolicitanteId() {
        return solicitanteId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getCategoriaId() {
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

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
