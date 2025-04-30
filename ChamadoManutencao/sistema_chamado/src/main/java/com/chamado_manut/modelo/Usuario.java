package com.chamado_manut.modelo;

public abstract class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String toString();
}
