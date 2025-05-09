package com.condowise.controller;

import com.condowise.model.*;
import com.condowise.service.RegistroVisitaService;

import java.util.List;
import java.util.Scanner;

public class RegistroVisitaController {
    private final RegistroVisitaService service;
    private final Scanner scanner;
    private Usuario usuario;

    public RegistroVisitaController() {
        this.service = new RegistroVisitaService();
        this.scanner = new Scanner(System.in);
    }

    public void login() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu andar: ");
        String andar = scanner.nextLine();

        System.out.println("Você é um (1) Morador ou (2) Porteiro?");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            usuario = new Morador(nome, andar);
            System.out.println("Bem-vindo, " + usuario.getNome() + "! Como Morador, você pode registrar visitantes.");
        } else if (opcao == 2) {
            usuario = new Porteiro(nome);
            System.out.println("Bem-vindo, " + usuario.getNome() + "! Como Porteiro, você pode registrar entrada e saída.");
        } else {
            System.out.println("Opção inválida! Tentando novamente.");
            login(); 
        }
    }

    public void registrarVisitante() {
        if (usuario instanceof Morador) {
            System.out.print("Digite o nome do visitante: ");
            String nomeVisitante = scanner.nextLine();

            Morador morador = (Morador) usuario;
            service.registrarVisitante(nomeVisitante, morador);
            System.out.println("Visitante registrado com sucesso!");
        } else {
            System.out.println("Somente moradores podem registrar visitantes!");
        }
    }

    public void registrarEntrada() {
        if (usuario instanceof Porteiro) {
            System.out.print("Digite o nome do visitante para registrar entrada: ");
            String nomeVisitante = scanner.nextLine();

            List<RegistroVisita> registrosEmAndamento = service.getRegistrosEmAndamento();
            RegistroVisita registro = null;

            for (RegistroVisita r : registrosEmAndamento) {
                if (r.getVisitante().getNome().equals(nomeVisitante)) {
                    registro = r;
                    break;
                }
            }

            if (registro != null) {
                service.registrarEntrada(registro);
                System.out.println("Entrada registrada para o visitante " + nomeVisitante);
            } else {
                System.out.println("Visitante não encontrado.");
            }
        } else {
            System.out.println("Somente porteiros podem registrar entrada!");
        }
    }

    public void registrarSaida() {
        if (usuario instanceof Porteiro) {
            System.out.print("Digite o nome do visitante para registrar saída: ");
            String nomeVisitante = scanner.nextLine();

            List<RegistroVisita> registrosEmAndamento = service.getRegistrosEmAndamento();
            RegistroVisita registro = null;

            for (RegistroVisita r : registrosEmAndamento) {
                if (r.getVisitante().getNome().equals(nomeVisitante)) {
                    registro = r;
                    break;
                }
            }

            if (registro != null) {
                service.registrarSaida(registro);
                System.out.println("Saída registrada para o visitante " + nomeVisitante);
            } else {
                System.out.println("Visitante não encontrado ou entrada não registrada.");
            }
        } else {
            System.out.println("Somente porteiros podem registrar saída!");
        }
    }

    public void exibirMenu() {
        login();

        while (true) {
            System.out.println("\n--- Menu ---");
            if (usuario instanceof Morador) {
                System.out.println("1. Registrar Visitante");
            }
            if (usuario instanceof Porteiro) {
                System.out.println("2. Registrar Entrada");
                System.out.println("3. Registrar Saída");
            }
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    if (usuario instanceof Morador) {
                        registrarVisitante();
                    }
                    break;
                case 2:
                    if (usuario instanceof Porteiro) {
                        registrarEntrada();
                    }
                    break;
                case 3:
                    if (usuario instanceof Porteiro) {
                        registrarSaida();
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
