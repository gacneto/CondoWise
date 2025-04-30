package com.condominio.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Encomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Morador morador;
    
    private LocalDateTime dataRecebimento;
    private LocalDateTime dataRetirada;
    private String descricao;
    private boolean retirada;

    public Encomenda() {}

    public Encomenda(Morador morador, String descricao) {
        this.morador = morador;
        this.descricao = descricao;
        this.dataRecebimento = LocalDateTime.now();
        this.retirada = false;
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

    public LocalDateTime getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRetirada() {
        return retirada;
    }

    public void setRetirada(boolean retirada) {
        this.retirada = retirada;
        if (retirada) {
            this.dataRetirada = LocalDateTime.now();
        }
    }
}