package com.condominio;

import com.condominio.model.Encomenda;
import com.condominio.model.Morador;
import com.condominio.model.Comunicado;
import com.condominio.model.ReservaAreaComum;
import com.condominio.model.Pagamento;
import com.condominio.repository.ComunicadoRepository;
import java.time.format.DateTimeFormatter;
import com.condominio.repository.EncomendaRepository;
import com.condominio.repository.MoradorRepository;
import com.condominio.repository.ReservaAreaComumRepository;
import com.condominio.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
    
    @Autowired
    private ReservaAreaComumRepository reservaAreaComumRepository;
    
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public void iniciar() {
        while (true) {
            System.out.println("\n=== Sistema de Gestão de Condomínio ===");
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
            System.out.println("7. Aprovar Reservas de Áreas Comuns");
            System.out.println("8. Gestão de Pagamentos");
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
                case 7:
                    aprovarReservas();
                    break;
                case 8:
                    menuGestaoPagamentos();
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
            System.out.println("4. Solicitar Reserva de Área Comum");
            System.out.println("5. Ver Minhas Reservas");
            System.out.println("6. Ver Meus Pagamentos");
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
                case 4:
                    solicitarReserva(morador);
                    break;
                case 5:
                    verMinhasReservas(morador);
                    break;
                case 6:
                    verMeusPagamentos(morador);
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
        
        System.out.print("Digite o nome do síndico: ");
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

    private void solicitarReserva(Morador morador) {
        System.out.println("\n=== Solicitar Reserva de Área Comum ===");
        System.out.println("1. Churrasqueira");
        System.out.println("2. Salão de Festas");
        System.out.print("Escolha a área: ");
        
        int opcaoArea = scanner.nextInt();
        scanner.nextLine();
        
        String area;
        switch (opcaoArea) {
            case 1:
                area = "Churrasqueira";
                break;
            case 2:
                area = "Salão de Festas";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        System.out.print("Digite o dia da reserva (1-31): ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês da reserva (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o ano da reserva: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Observações (opcional): ");
        String observacao = scanner.nextLine();
        
        LocalDate dataReserva = LocalDate.of(ano, mes, dia);
        
        // Verificar se já existe reserva para esta data
        List<ReservaAreaComum> reservasExistentes = reservaAreaComumRepository.findByDataReserva(dataReserva);
        if (!reservasExistentes.isEmpty()) {
            System.out.println("Já existe uma reserva para esta data!");
            return;
        }
        
        ReservaAreaComum reserva = new ReservaAreaComum(morador, area, dataReserva, observacao);
        reservaAreaComumRepository.save(reserva);
        System.out.println("Reserva solicitada com sucesso! Aguarde a aprovação do síndico.");
    }
    
    private void verMinhasReservas(Morador morador) {
        List<ReservaAreaComum> reservas = reservaAreaComumRepository.findByMoradorId(morador.getId());
        
        if (reservas.isEmpty()) {
            System.out.println("Você não possui reservas.");
            return;
        }
        
        System.out.println("\n=== Suas Reservas ===");
        for (ReservaAreaComum reserva : reservas) {
            System.out.println("Área: " + reserva.getArea());
            System.out.println("Data: " + reserva.getDataReserva().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Status: " + (reserva.isAprovada() ? "Aprovada" : "Aguardando aprovação"));
            if (reserva.getObservacao() != null && !reserva.getObservacao().isEmpty()) {
                System.out.println("Observações: " + reserva.getObservacao());
            }
            System.out.println("-------------------");
        }
    }
    
    private void aprovarReservas() {
        List<ReservaAreaComum> reservasPendentes = reservaAreaComumRepository.findByAprovadaFalse();
        
        if (reservasPendentes.isEmpty()) {
            System.out.println("Não há reservas pendentes de aprovação.");
            return;
        }
        
        System.out.println("\n=== Reservas Pendentes de Aprovação ===");
        for (ReservaAreaComum reserva : reservasPendentes) {
            System.out.println("ID: " + reserva.getId());
            System.out.println("Morador: " + reserva.getMorador().getNome() + " - Apartamento: " + reserva.getMorador().getApartamento());
            System.out.println("Área: " + reserva.getArea());
            System.out.println("Data: " + reserva.getDataReserva().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            if (reserva.getObservacao() != null && !reserva.getObservacao().isEmpty()) {
                System.out.println("Observações: " + reserva.getObservacao());
            }
            System.out.println("-------------------");
        }
        
        System.out.print("\nDigite o ID da reserva que deseja aprovar (ou 0 para voltar): ");
        Long idReserva = scanner.nextLong();
        scanner.nextLine();
        
        if (idReserva == 0) {
            return;
        }
        
        System.out.print("Deseja aprovar (S/N)? ");
        String resposta = scanner.nextLine().toUpperCase();
        
        if (resposta.equals("S")) {
            ReservaAreaComum reserva = reservaAreaComumRepository.findById(idReserva).orElse(null);
            if (reserva != null) {
                reserva.setAprovada(true);
                reservaAreaComumRepository.save(reserva);
                System.out.println("Reserva aprovada com sucesso!");
            } else {
                System.out.println("Reserva não encontrada!");
            }
        }
    }

    private void menuGestaoPagamentos() {
        while (true) {
            System.out.println("\n=== Gestão de Pagamentos ===");
            System.out.println("1. Emitir Boleto");
            System.out.println("2. Registrar Pagamento");
            System.out.println("3. Ver Pagamentos Pendentes");
            System.out.println("4. Ver Histórico de Pagamentos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    emitirBoleto();
                    break;
                case 2:
                    registrarPagamento();
                    break;
                case 3:
                    verPagamentosPendentes();
                    break;
                case 4:
                    verHistoricoPagamentos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void emitirBoleto() {
        System.out.print("Número do apartamento: ");
        String apartamento = scanner.nextLine();

        Morador morador = moradorRepository.findByApartamento(apartamento);
        if (morador == null) {
            System.out.println("Morador não encontrado");
            return;
        }

        System.out.print("Valor do boleto: R$ ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Descrição do pagamento: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de vencimento (dd/MM/yyyy): ");
        String dataVencimentoStr = scanner.nextLine();
        LocalDate dataVencimento = LocalDate.parse(dataVencimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Pagamento pagamento = new Pagamento(morador, valor, descricao, dataVencimento);
        pagamentoRepository.save(pagamento);
        System.out.println("Boleto emitido com sucesso");
    }

    private void registrarPagamento() {
        System.out.print("Número do apartamento: ");
        String apartamento = scanner.nextLine();

        Morador morador = moradorRepository.findByApartamento(apartamento);
        if (morador == null) {
            System.out.println("Morador não encontrado");
            return;
        }

        List<Pagamento> pagamentosPendentes = pagamentoRepository.findByMoradorAndPago(morador, false);
        if (pagamentosPendentes.isEmpty()) {
            System.out.println("Não há pagamentos pendentes para este morador");
            return;
        }

        System.out.println("\nPagamentos Pendentes:");
        for (Pagamento pagamento : pagamentosPendentes) {
            System.out.println("ID: " + pagamento.getId() + 
                             " - Valor: R$ " + pagamento.getValor() + 
                             " - Descrição: " + pagamento.getDescricao() +
                             " - Vencimento: " + pagamento.getDataVencimento());
        }

        System.out.print("\nDigite o ID do pagamento registrado: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Pagamento pagamento = pagamentoRepository.findById(id).orElse(null);
        if (pagamento != null && pagamento.getMorador().getId().equals(morador.getId())) {
            pagamento.setPago(true);
            pagamento.setDataPagamento(LocalDate.now());
            pagamentoRepository.save(pagamento);
            System.out.println("Pagamento registrado com sucesso!");
        } else {
            System.out.println("Pagamento não encontrado");
        }
    }

    private void verPagamentosPendentes() {
        List<Pagamento> pagamentosPendentes = pagamentoRepository.findByPago(false);
        if (pagamentosPendentes.isEmpty()) {
            System.out.println("Não há pagamentos pendentes");
            return;
        }

        System.out.println("\nPagamentos Pendentes:");
        for (Pagamento pagamento : pagamentosPendentes) {
            System.out.println("Apartamento: " + pagamento.getMorador().getApartamento() +
                             " - Valor: R$ " + pagamento.getValor() +
                             " - Descrição: " + pagamento.getDescricao() +
                             " - Vencimento: " + pagamento.getDataVencimento());
        }
    }

    private void verHistoricoPagamentos() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        if (pagamentos.isEmpty()) {
            System.out.println("Não há pagamentos registrados");
            return;
        }

        System.out.println("\nHistórico de Pagamentos:");
        for (Pagamento pagamento : pagamentos) {
            System.out.println("Apartamento: " + pagamento.getMorador().getApartamento() +
                             " - Valor: R$ " + pagamento.getValor() +
                             " - Descrição: " + pagamento.getDescricao() +
                             " - Vencimento: " + pagamento.getDataVencimento() +
                             " - Status: " + (pagamento.isPago() ? "Pago" : "Pendente") +
                             (pagamento.isPago() ? " - Data do Pagamento: " + pagamento.getDataPagamento() : ""));
        }
    }

    private void verMeusPagamentos(Morador morador) {
        List<Pagamento> pagamentos = pagamentoRepository.findByMorador(morador);
        if (pagamentos.isEmpty()) {
            System.out.println("Não há pagamentos registrados para seu apartamento");
            return;
        }

        System.out.println("\nSeus Pagamentos:");
        for (Pagamento pagamento : pagamentos) {
            System.out.println("Valor: R$ " + pagamento.getValor() +
                             " - Descrição: " + pagamento.getDescricao() +
                             " - Vencimento: " + pagamento.getDataVencimento() +
                             " - Status: " + (pagamento.isPago() ? "Pago" : "Pendente") +
                             (pagamento.isPago() ? " - Data do Pagamento: " + pagamento.getDataPagamento() : ""));
        }
    }
} 