package com.condominio.service;

import com.condominio.model.Morador;
import com.condominio.model.Veiculo;
import com.condominio.repository.MoradorRepository;
import com.condominio.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoService {

    private final MoradorRepository moradorRepository;
    private final VeiculoRepository veiculoRepository;

    private static final int LIMITE_VEICULOS_POR_MORADOR = 2;

    public EstacionamentoService(MoradorRepository moradorRepository, VeiculoRepository veiculoRepository) {
        this.moradorRepository = moradorRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public Morador cadastrarMorador(String nome) {
        Morador existente = moradorRepository.findByNome(nome);
        if (existente != null) {
            System.out.println("Morador já existe.");
            return existente;
        }

        Morador novo = new Morador(nome);
        return moradorRepository.save(novo);
    }

    public void cadastrarVeiculo(String nomeMorador, String placa, String modelo, String cor) {
        Morador morador = moradorRepository.findByNome(nomeMorador);

        if (morador == null) {
            System.out.println("Morador não encontrado.");
            return;
        }

        if (morador.getVeiculos().size() >= LIMITE_VEICULOS_POR_MORADOR) {
            System.out.println("Você atingiu o limite de veículos permitidos por morador.");
            return;
        }

        // Criando e salvando o novo veículo no banco
        Veiculo veiculo = new Veiculo(placa, modelo, cor);
        morador.adicionarVeiculo(veiculo);

        // Salvando o veículo no repositório
        veiculoRepository.save(veiculo);
        moradorRepository.save(morador);

        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void listarVeiculos(String nomeMorador) {
        Morador morador = moradorRepository.findByNome(nomeMorador);

        if (morador == null) {
            System.out.println("Morador não encontrado.");
            return;
        }

        if (morador.getVeiculos().isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("Veículos de " + nomeMorador + ":");
        for (Veiculo v : morador.getVeiculos()) {
            System.out.println("- Placa: " + v.getPlaca() + ", Modelo: " + v.getModelo() + ", Cor: " + v.getCor());
        }
    }
}
