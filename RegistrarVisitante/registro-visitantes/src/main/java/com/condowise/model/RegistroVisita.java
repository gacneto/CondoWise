package com.condowise.model;

import java.time.LocalDateTime;

public class RegistroVisita {
    private Visitante visitante;
    private Morador morador;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public RegistroVisita(Visitante visitante, Morador morador) {
        this.visitante = visitante;
        this.morador = morador;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Morador getMorador() {
        return morador;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public boolean isEntradaRegistrada() {
        return entrada != null;
    }

    public boolean isSaidaRegistrada() {
        return saida != null;
    }

    public void registrarEntrada() {
        if (this.entrada == null) {
            this.entrada = LocalDateTime.now();
        }
    }

    public void registrarSaida() {
        if (this.saida == null) {
            this.saida = LocalDateTime.now();
        }
    }

    @Override
    public String toString() {
        return String.format("Visitante: %s | Morador: %s | Entrada: %s | Saída: %s",
                visitante.getNome(),
                morador.getNome(),
                entrada != null ? entrada.toString() : "N/A",
                saida != null ? saida.toString() : "N/A");
    }

}
