package com.condominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class PagamentoTest {
    
    @Test
    public void deveCriarPagamentoComSucesso() {
        Morador morador = new Morador("Lucas", "101");
        double valor = 150.00;
        String descricao = "Mensalidade";
        LocalDate dataVencimento = LocalDate.now().plusDays(5);
        
        Pagamento pagamento = new Pagamento(morador, valor, descricao, dataVencimento);
        
        assertNotNull(pagamento);
        assertEquals(morador, pagamento.getMorador());
        assertEquals(valor, pagamento.getValor());
        assertEquals(descricao, pagamento.getDescricao());
        assertEquals(dataVencimento, pagamento.getDataVencimento());
        assertFalse(pagamento.isPago());
    }
    
    @Test
    public void deveRegistrarPagamento() {
        Morador morador = new Morador("João Pedro", "202");
        Pagamento pagamento = new Pagamento(morador, 200.00, "Taxa Extra", LocalDate.now());
        
        LocalDate dataPagamento = LocalDate.now();
        pagamento.setDataPagamento(dataPagamento);
        pagamento.setPago(true);
        
        assertTrue(pagamento.isPago());
        assertEquals(dataPagamento, pagamento.getDataPagamento());
    }
} 