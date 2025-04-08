package com.condominio;

import com.condominio.model.Encomenda;
import com.condominio.model.Morador;
import com.condominio.model.Comunicado;
import com.condominio.repository.ComunicadoRepository;
import java.time.format.DateTimeFormatter;
import com.condominio.repository.EncomendaRepository;
import com.condominio.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuPrincipal {
    private final Scanner scanner = new Scanner(System.in);
    
    @Autowired
    private MoradorRepository moradorRepository;
    
    @Autowired
    private EncomendaRepository encomendaRepository;
    
    @Autowired
    private ComunicadoRepository comunicadoRepository;

    public void iniciar() {
        while (true) {
            System.out.println("\n=== Sistema de Gestão de Encomendas ===");
            System.out.println("1. Modo Síndico");
            System.out.println("2. Modo Morador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    menuSindico();
                    break;
                case 2:
                    menuMorador();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuSindico() {
        while (true) {
            System.out.println("\n=== Menu do Síndico ===");
            System.out.println("1. Cadastrar Morador");
            System.out.println("2. Remover Morador");
            System.out.println("3. Registrar Encomenda");
            System.out.println("4. Listar Moradores");
            System.out.println("5. Emitir Comunicado");  
            System.out.println("6. Ver Comunicados"); 
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    cadastrarMorador();
                    break;
                case 2:
                    removerMorador();
                    break;
                case 3:
                    registrarEncomenda();
                    break;
                case 4:
                    listarMoradores();
                    break;
                case 5:
                    emitirComunicado();    
                    break;
                case 6:
                    verComunicados();      
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menuMorador() {
        System.out.print("Digite o número do apartamento: ");
        String apartamento = scanner.nextLine();

        Morador morador = moradorRepository.findByApartamento(apartamento);
        if (morador == null) {
            System.out.println("Apartamento não encontrado!");
            return;
        }

        while (true) {
            System.out.println("\n=== Menu do Morador ===");
            System.out.println("1. Ver Encomendas Pendentes");
            System.out.println("2. Confirmar Recebimento de Encomenda");
            System.out.println("3. Ver Comunicados");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    verEncomendasPendentes(morador);
                    break;
                case 2:
                    confirmarRecebimento(morador);
                    break;
                case 3:
                    verComunicados();      
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarMorador() {
        System.out.print("Nome do morador: ");
        String nome = scanner.nextLine();
        System.out.print("Número do apartamento: ");
        String apartamento = scanner.nextLine();

        Morador morador = new Morador(nome, apartamento);
        moradorRepository.save(morador);
        System.out.println("Morador cadastrado com sucesso!");
    }

    private void removerMorador() {
        System.out.print("Número do apartamento do morador a ser removido: ");
        String apartamento = scanner.nextLine();

        Morador morador = moradorRepository.findByApartamento(apartamento);
        if (morador != null) {
            moradorRepository.delete(morador);
            System.out.println("Morador removido com sucesso!");
        } else {
            System.out.println("Morador não encontrado!");
        }
    }

    private void registrarEncomenda() {
        System.out.print("Número do apartamento do destinatário: ");
        String apartamento = scanner.nextLine();

        Morador morador = moradorRepository.findByApartamento(apartamento);
        if (morador == null) {
            System.out.println("Morador não encontrado!");
            return;
        }

        System.out.print("Descrição da encomenda: ");
        String descricao = scanner.nextLine();

        Encomenda encomenda = new Encomenda(morador, descricao);
        encomendaRepository.save(encomenda);
        System.out.println("Encomenda registrada com sucesso!");
    }

    private void listarMoradores() {
        List<Morador> moradores = moradorRepository.findAll();
        if (moradores.isEmpty()) {
            System.out.println("Não há moradores cadastrados!");
            return;
        }

        System.out.println("\nLista de Moradores:");
        for (Morador morador : moradores) {
            System.out.println("Apartamento: " + morador.getApartamento() + " - Nome: " + morador.getNome());
        }
    }

    private void verEncomendasPendentes(Morador morador) {
        List<Encomenda> encomendas = encomendaRepository.findByMoradorAndRetirada(morador, false);
        if (encomendas.isEmpty()) {
            System.out.println("Não há encomendas pendentes!");
            return;
        }

        System.out.println("\nEncomendas Pendentes:");
        for (Encomenda encomenda : encomendas) {
            System.out.println("ID: " + encomenda.getId() + " - Descrição: " + encomenda.getDescricao() +
                    " - Data de Recebimento: " + encomenda.getDataRecebimento());
        }
    }

    private void confirmarRecebimento(Morador morador) {
        List<Encomenda> encomendas = encomendaRepository.findByMoradorAndRetirada(morador, false);
        if (encomendas.isEmpty()) {
            System.out.println("Não há encomendas pendentes!");
            return;
        }

        System.out.println("\nEncomendas Pendentes:");
        for (Encomenda encomenda : encomendas) {
            System.out.println("ID: " + encomenda.getId() + " - Descrição: " + encomenda.getDescricao());
        }

        System.out.print("\nDigite o ID da encomenda que deseja confirmar o recebimento: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); 

        Encomenda encomenda = encomendaRepository.findById(id).orElse(null);
        if (encomenda != null && encomenda.getMorador().getId().equals(morador.getId())) {
            encomenda.setRetirada(true);
            encomendaRepository.save(encomenda);
            System.out.println("Recebimento confirmado com sucesso!");
        } else {
            System.out.println("Encomenda não encontrada ou não pertence ao seu apartamento!");
        }
    } 

    private void emitirComunicado() {
        System.out.print("Digite o título do comunicado: ");
        String titulo = scanner.nextLine();
        
        System.out.println("Digite a mensagem do comunicado:");
        String mensagem = scanner.nextLine();
        
        System.out.print("Digite o nome do autor (síndico): ");
        String autor = scanner.nextLine();

        Comunicado comunicado = new Comunicado(titulo, mensagem, autor);
        comunicadoRepository.save(comunicado);
        System.out.println("Comunicado emitido com sucesso!");
    }

    private void verComunicados() {
        List<Comunicado> comunicados = comunicadoRepository.findAllByOrderByDataPublicacaoDesc();
        if (comunicados.isEmpty()) {
            System.out.println("Não há comunicados disponíveis!");
            return;
        }

        System.out.println("\n=== Comunicados ===");
        for (Comunicado comunicado : comunicados) {
            System.out.println("\nTítulo: " + comunicado.getTitulo());
            System.out.println("Autor: " + comunicado.getAutor());
            System.out.println("Data: " + comunicado.getDataPublicacao().format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            System.out.println("Mensagem: " + comunicado.getMensagem());
            System.out.println("-".repeat(50));
        }
    }
} 