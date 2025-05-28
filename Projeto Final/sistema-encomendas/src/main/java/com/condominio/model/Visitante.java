package com.condominio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    private String nome;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataResposta;
    private boolean aprovado;
    private String observacaoSindico;

    public Visitante() {
    }

    public Visitante(Morador morador, String nome) {
        this.morador = morador;
        this.nome = nome;
        this.dataEntrada = LocalDateTime.now();
        this.aprovado = false;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDateTime dataResposta) {
        this.dataResposta = dataResposta;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public String getObservacaoSindico() {
        return observacaoSindico;
    }

    public void setObservacaoSindico(String observacaoSindico) {
        this.observacaoSindico = observacaoSindico;
    }
} 