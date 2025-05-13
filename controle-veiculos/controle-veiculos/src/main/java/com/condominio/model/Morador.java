package com.condominio.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "morador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Veiculo> veiculos = new ArrayList<>();

    // Construtores
    public Morador() {}

    public Morador(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public List<Veiculo> getVeiculos() { return veiculos; }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setMorador(this);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
        veiculo.setMorador(null);
    }
}
