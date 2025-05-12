package com.condominio;

import com.condominio.service.EstacionamentoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ControleVeiculosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ControleVeiculosApplication.class, args);
		EstacionamentoService service = context.getBean(EstacionamentoService.class);

		Scanner scanner = new Scanner(System.in);
		int opcao = -1;

		while (opcao != 0) {
			System.out.println("\n==== Menu Principal ====");
			System.out.println("1. Cadastrar Morador");
			System.out.println("2. Cadastrar Veículo");
			System.out.println("3. Listar Veículos de um Morador");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Opção inválida.");
				continue;
			}

			switch (opcao) {
				case 1:
					System.out.print("Digite o nome do morador: ");
					String nomeMorador = scanner.nextLine();
					service.cadastrarMorador(nomeMorador);
					break;

				case 2:
					System.out.print("Digite o nome do morador: ");
					String nome = scanner.nextLine();
					System.out.print("Digite a placa do veículo: ");
					String placa = scanner.nextLine();
					System.out.print("Digite o modelo do veículo: ");
					String modelo = scanner.nextLine();
					System.out.print("Digite a cor do veículo: ");
					String cor = scanner.nextLine();
					service.cadastrarVeiculo(nome, placa, modelo, cor);
					break;

				case 3:
					System.out.print("Digite o nome do morador: ");
					String nomeConsulta = scanner.nextLine();
					service.listarVeiculos(nomeConsulta);
					break;

				case 0:
					System.out.println("Saindo...");
					break;

				default:
					System.out.println("Opção inválida.");
			}
		}

		scanner.close();
	}
}
