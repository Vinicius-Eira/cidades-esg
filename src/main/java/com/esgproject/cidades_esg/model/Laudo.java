package com.esgproject.cidades_esg.model;

import jakarta.persistence.*;

@Entity
public class Laudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricaoProblema;
    private String laudoGerado;
    private Double valorEstimado;

    public Laudo() {}

    public Laudo(String descricaoProblema, String laudoGerado, Double valorEstimado) {
        this.descricaoProblema = descricaoProblema;
        this.laudoGerado = laudoGerado;
        this.valorEstimado = valorEstimado;
    }

    public Long getId() { return id; }

    public String getDescricaoProblema() { return descricaoProblema; }
    public void setDescricaoProblema(String descricaoProblema) { this.descricaoProblema = descricaoProblema; }

    public String getLaudoGerado() { return laudoGerado; }
    public void setLaudoGerado(String laudoGerado) { this.laudoGerado = laudoGerado; }

    public Double getValorEstimado() { return valorEstimado; }
    public void setValorEstimado(Double valorEstimado) { this.valorEstimado = valorEstimado; }
}