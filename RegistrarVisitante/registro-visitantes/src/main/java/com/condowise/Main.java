package com.condowise;

import com.condowise.model.*;
import com.condowise.service.RegistroVisitaService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RegistroVisitaService service = new RegistroVisitaService();

    public static void main(String[] args) {
        while (true) {
            limparTerminal();
            System.out.println("=== Tela de Login ===");
            System.out.println("1. Morador");
            System.out.println("2. Porteiro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> menuMorador();
                case 2 -> menuPorteiro();
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida. Pressione Enter para continuar...");
            }
            scanner.nextLine();
        }
    }

    private static void menuMorador() {
        limparTerminal();
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu andar: ");
        String andar = scanner.nextLine();
        Morador morador = new Morador(nome, andar);

        while (true) {
            limparTerminal();
            System.out.println("=== Menu Morador ===");
            System.out.println("1. Cadastrar visitante");
            System.out.println("2. Ver visitantes cadastrados");
            System.out.println("0. Voltar ao login");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome do visitante: ");
                    String nomeVisitante = scanner.nextLine();
                    RegistroVisita registro = service.registrarVisitante(nomeVisitante, morador);
                    System.out.println("Visitante " + registro.getVisitante().getNome() + " cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.println("=== Visitantes cadastrados ===");
                    List<RegistroVisita> registros = service.getRegistrosPorMorador(morador);
                    for (RegistroVisita r : registros) {
                        System.out.println(r);
                    }
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private static void menuPorteiro() {
        limparTerminal();
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Bem-vindo, porteiro " + nome + "!");


        while (true) {
            limparTerminal();
            System.out.println("=== Menu Porteiro ===");
            System.out.println("1. Ver visitantes em andamento");
            System.out.println("2. Registrar entrada");
            System.out.println("3. Registrar saída");
            System.out.println("0. Voltar ao login");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== Visitantes em andamento ===");
                    listarRegistros(service.getRegistrosEmAndamento());
                }
                case 2 -> {
                    System.out.println("Digite o índice do visitante para registrar entrada:");
                    listarRegistros(service.getRegistrosEmAndamento());
                    int index = Integer.parseInt(scanner.nextLine());
                    service.registrarEntrada(service.getRegistrosEmAndamento().get(index));
                    System.out.println("Entrada registrada.");
                }
                case 3 -> {
                    System.out.println("Digite o índice do visitante para registrar saída:");
                    listarRegistros(service.getRegistrosEmAndamento());
                    int index = Integer.parseInt(scanner.nextLine());
                    service.registrarSaida(service.getRegistrosEmAndamento().get(index));
                    System.out.println("Saída registrada.");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private static void listarRegistros(List<RegistroVisita> registros) {
        if (registros.isEmpty()) {
            System.out.println("Nenhum visitante cadastrado.");
            return;
        }
        for (int i = 0; i < registros.size(); i++) {
            System.out.println(i + ". " + registros.get(i));
        }
    }

    private static void limparTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Não foi possível limpar o terminal.");
        }
    }
}
