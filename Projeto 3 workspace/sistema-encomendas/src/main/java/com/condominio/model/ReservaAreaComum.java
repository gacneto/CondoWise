package com.condominio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ReservaAreaComum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    private String area; 
    private LocalDate dataReserva;
    private boolean aprovada;
    private String observacao;

    public ReservaAreaComum() {
    }

    public ReservaAreaComum(Morador morador, String area, LocalDate dataReserva, String observacao) {
        this.morador = morador;
        this.area = area;
        this.dataReserva = dataReserva;
        this.observacao = observacao;
        this.aprovada = false; 
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
} 