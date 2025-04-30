package com.chamado_manut.servico;

import com.chamado_manut.modelo.Morador;
import com.chamado_manut.modelo.Chamado;
import com.chamado_manut.modelo.StatusChamado;

import java.util.ArrayList;
import java.util.List;

public class SistemaChamadosService {
    private List<Chamado> chamados = new ArrayList<>();

    public void criarChamado(Morador morador, String descricao) {
        Chamado chamado = new Chamado(morador, descricao);
        chamado.setStatus(StatusChamado.PENDENTE);
        chamados.add(chamado);
        System.out.println("Chamado criado com sucesso: " + chamado);
    }

    public List<Chamado> listarChamados() {
        return chamados;  
    }

    public void listarChamadosConsole() {
        if (chamados.isEmpty()) {
            System.out.println("Não há chamados registrados.");
        } else {
            for (Chamado chamado : chamados) {
                System.out.println("ID: " + chamado.getId() + " | Descrição: " + chamado.getDescricao() + " | Status: " + chamado.getStatus());
            }
        }
    }

    public void alterarStatusChamado(int id, StatusChamado status) {
        for (Chamado chamado : chamados) {
            if (chamado.getId() == id) {
                chamado.setStatus(status);
                System.out.println("Status do chamado alterado para: " + status);
                return;
            }
        }
        System.out.println("Chamado não encontrado.");
    }    
}
