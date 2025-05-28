package com.condominio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    @Enumerated(EnumType.STRING)
    private TipoChamado tipo;

    private String descricao;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataResposta;
    private boolean aprovado;
    private String observacaoSindico;

    public enum TipoChamado {
        BANHEIRO_COMUM,
        ELEVADOR,
        LIMPEZA
    }

    public Chamado() {
    }

    public Chamado(Morador morador, TipoChamado tipo, String descricao) {
        this.morador = morador;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataAbertura = LocalDateTime.now();
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

    public TipoChamado getTipo() {
        return tipo;
    }

    public void setTipo(TipoChamado tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
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