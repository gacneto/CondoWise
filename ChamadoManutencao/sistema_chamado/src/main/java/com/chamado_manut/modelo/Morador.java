package com.chamado_manut.modelo;

public class Morador extends Usuario {
    private String apartamento;

    public Morador(String nome, String apartamento) {
        super(nome);
        this.apartamento = apartamento;
    }

    public String getApartamento() {
        return apartamento;
    }

    @Override
    public String toString() {
        return "Morador: " + getNome() + ", Apartamento: " + apartamento;
    }
}
