package com.example.sgs.filtro;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SolicitacaoFiltros {
    private Integer solicitanteId;
    private Integer categoriaId;
    private Integer statusId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataInicialSolicitacao;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataFinalSolicitacao;

    public Integer getSolicitanteId() {
        return this.solicitanteId;
    }

    public void setSolicitanteId(Integer solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setDataInicialSolicitacao(LocalDate dataInicialSolicitacao) {
        this.dataInicialSolicitacao = dataInicialSolicitacao;
    }

    public LocalDate getDataInicialSolicitacao() {
        return dataInicialSolicitacao;
    }

    public void setDataFinalSolicitacao(LocalDate dataFinalSolicitacao) {
        this.dataFinalSolicitacao = dataFinalSolicitacao;
    }

    public LocalDate getDataFinalSolicitacao() {
        return dataFinalSolicitacao;
    }

    public Boolean hasCategoriaId() {
        return this.categoriaId != null;
    }

    public Boolean hasSolicitanteId() {
        return this.solicitanteId != null;
    }

    public Boolean hasDataInicialSolicitacao() {
        return this.dataInicialSolicitacao != null;
    }

    public Boolean hasDataFinalSolicitacao() {
        return this.dataFinalSolicitacao != null;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Boolean hasStatusId() {
        return this.statusId != null;
    }

    public Integer getStatusId() {
        return this.statusId;
    }
}
