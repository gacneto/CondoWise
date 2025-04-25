package com.chamado_manut.modelo;

public class Sindico extends Usuario {

    public Sindico(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Síndico: " + getNome();
    }
}
