package com.chamado_manut.modelo;

public class Chamado {
    private int id;
    private String descricao;
    private StatusChamado status;
    private Morador morador;

    public Chamado(Morador morador, String descricao) {
        this.morador = morador;
        this.descricao = descricao;
        this.status = StatusChamado.PENDENTE;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Chamado ID: " + id + ", Descrição: " + descricao + ", Status: " + status;
    }
}
