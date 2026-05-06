package com.example.sgs.model;

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

    public String getCPFOuCNPJ() {
        return CPFOuCNPJ;
    }

    public void setCPFOuCNPJ(String CPFOuCNPJ) {
        this.CPFOuCNPJ = CPFOuCNPJ;
    }
}