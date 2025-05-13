package com.condominio.model;

import jakarta.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String modelo;
    private String cor;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    // Construtores
    public Veiculo() {}

    public Veiculo(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getPlaca() { return placa; }

    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCor() { return cor; }

    public void setCor(String cor) { this.cor = cor; }

    public Morador getMorador() { return morador; }

    public void setMorador(Morador morador) { this.morador = morador; }
    
    @Override
public String toString() {
    return "Placa: " + placa + ", Modelo: " + modelo + ", Cor: " + cor;
}

}
    