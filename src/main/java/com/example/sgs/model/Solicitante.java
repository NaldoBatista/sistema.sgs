package com.example.sgs.model;

import com.example.sgs.utils.Utils;

public class Solicitante {
    private int id;
    private String nome;
    private String CPFOuCNPJ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPFOuCNPJComMascara() {
        return Utils.formatarCPFOuCNPJ(CPFOuCNPJ);
    }

    public void setCPFOuCNPJ(String CPFOuCNPJ) {
        this.CPFOuCNPJ = CPFOuCNPJ;
    }
}