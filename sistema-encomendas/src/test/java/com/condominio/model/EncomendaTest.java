package com.condominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class EncomendaTest {
    
    @Test
    public void deveCriarEncomendaComSucesso() {
        
        Morador morador = new Morador("Caio", "101");
        String descricao = "Pacote de roupas";
        
        
        Encomenda encomenda = new Encomenda(morador, descricao);
        
        
        assertNotNull(encomenda);
        assertEquals(morador, encomenda.getMorador());
        assertEquals(descricao, encomenda.getDescricao());
        assertFalse(encomenda.isRetirada());
        assertNotNull(encomenda.getDataRecebimento());
    }
    
    @Test
    public void deveConfirmarRecebimentoDaEncomenda() {
       
        Morador morador = new Morador("Thiago", "202");
        Encomenda encomenda = new Encomenda(morador, "Livros");
        
       
        encomenda.setRetirada(true);
        
        
        assertTrue(encomenda.isRetirada());
    }
    
    @Test
    public void deveRetornarDataRecebimentoCorreta() {
        
        Morador morador = new Morador("Lucas", "303");
        Encomenda encomenda = new Encomenda(morador, "Eletrônicos");
        
       
        LocalDateTime dataRecebimento = encomenda.getDataRecebimento();
        
        
        assertNotNull(dataRecebimento);
        assertTrue(dataRecebimento.isBefore(LocalDateTime.now().plusMinutes(1)));
    }
} 