package com.condominio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    private String modelo;
    private String placa;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataResposta;
    private boolean aprovado;
    private String observacaoSindico;

    public Veiculo() {
    }

    public Veiculo(Morador morador, String modelo, String placa) {
        this.morador = morador;
        this.modelo = modelo;
        this.placa = placa;
        this.dataCadastro = LocalDateTime.now();
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
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