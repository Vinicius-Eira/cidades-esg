package com.esgproject.cidades_esg.model;

import jakarta.persistence.*;

@Entity
public class PontosFidelidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario; // nome ou email do usuário
    private int pontos;

    public PontosFidelidade() {}

    public PontosFidelidade(String usuario, int pontos) {
        this.usuario = usuario;
        this.pontos = pontos;
    }

    public Long getId() { return id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public int getPontos() { return pontos; }
    public void setPontos(int pontos) { this.pontos = pontos; }
}