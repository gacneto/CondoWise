package com.condowise.model;

public class Morador extends Usuario {
    private String andar;

    public Morador(String nome, String andar) {
        super(nome); 
        this.andar = andar;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }
}
