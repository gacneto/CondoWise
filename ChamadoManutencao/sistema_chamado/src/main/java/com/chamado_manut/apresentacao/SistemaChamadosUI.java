package com.chamado_manut.apresentacao;

import com.chamado_manut.modelo.Morador;
import com.chamado_manut.modelo.Chamado;
import com.chamado_manut.modelo.StatusChamado;
import com.chamado_manut.servico.SistemaChamadosService;

import java.io.IOException;
import java.util.Scanner;

public class SistemaChamadosUI {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaChamadosService service = new SistemaChamadosService();
    private static boolean isSindico = false;

    public static void login() {
        while (true) {
            System.out.println("Escolha uma opção para login:");
            System.out.println("1. Entrar como Morador");
            System.out.println("2. Entrar como Síndico");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    isSindico = false;
                    menu();
                    break;
                case 2:
                    isSindico = true;
                    menu();
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menu() {
        while (true) {
            limparConsole();
            System.out.println("Menu:");

            if (isSindico) {
                System.out.println("1. Ver Todos os Chamados");
                System.out.println("2. Alterar Status de Chamado");
            } else {
                System.out.println("1. Criar Chamado");
                System.out.println("2. Acompanhar Chamado");
            }

            System.out.println("3. Sair para Login");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    if (isSindico) {
                        verChamados();
                    } else {
                        criarChamado();
                    }
                    break;
                case 2:
                    if (isSindico) {
                        alterarStatusChamado();
                    } else {
                        acompanharChamado();
                    }
                    break;
                case 3:
                    login();  
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private static void verChamados() {
        service.listarChamadosConsole();
    }

    private static void criarChamado() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o apartamento: ");
        String apartamento = scanner.nextLine();

        Morador morador = new Morador(nome, apartamento);
        System.out.print("Descreva o problema: ");
        String descricao = scanner.nextLine();

        service.criarChamado(morador, descricao);
    }

    private static void acompanharChamado() {
        if (service.listarChamados().isEmpty()) {
            System.out.println("Não há chamados registrados.");
        } else {
            for (Chamado chamado : service.listarChamados()) {
                System.out.println("ID: " + chamado.getId() + " | Descrição: " + chamado.getDescricao() + " | Status: " + chamado.getStatus());
            }
        }
    }

    private static void alterarStatusChamado() {
        System.out.println("Lista de Chamados:");
        
        int index = 0;
        for (Chamado chamado : service.listarChamados()) {
            System.out.println(index + ". " + chamado);
            index++;
        }
    
        System.out.print("Digite o número do chamado para alterar o status: ");
        int numeroChamado = scanner.nextInt();
        scanner.nextLine(); 
    
        if (numeroChamado < 0 || numeroChamado >= service.listarChamados().size()) {
            System.out.println("Número de chamado inválido.");
            return;
        }
    
        Chamado chamadoSelecionado = service.listarChamados().get(numeroChamado);
    
        System.out.println("Escolha o novo status:");
        System.out.println("1. Pendente");
        System.out.println("2. Em Andamento");
        System.out.println("3. Resolvido");
    
        int statusEscolhido = scanner.nextInt();
        scanner.nextLine();
    
        StatusChamado status = StatusChamado.PENDENTE;
        if (statusEscolhido == 2) {
            status = StatusChamado.EM_ANDAMENTO;
        } else if (statusEscolhido == 3) {
            status = StatusChamado.RESOLVIDO;
        }
    
        service.alterarStatusChamado(chamadoSelecionado.getId(), status);
    }    

    public static void limparConsole() {
    String sistemaOperacional = System.getProperty("os.name").toLowerCase();

    try {
        if (sistemaOperacional.contains("win")) {
            // Comando para Windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            // Comando para Linux e macOS
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        login();
    }
}
