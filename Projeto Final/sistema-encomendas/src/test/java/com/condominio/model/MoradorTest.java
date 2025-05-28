package com.condominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoradorTest {
    
    @Test
    public void deveCriarMoradorComSucesso() {
       
        String nome = "João Silva";
        String apartamento = "101";
        
       
        Morador morador = new Morador(nome, apartamento);
        
        assertNotNull(morador);
        assertEquals(nome, morador.getNome());
        assertEquals(apartamento, morador.getApartamento());
    }
    
    @Test
    public void deveRetornarDadosCorretosDoMorador() {
        
        String nome = "Maria Santos";
        String apartamento = "202";
        Morador morador = new Morador(nome, apartamento);
        
       
        String nomeRetornado = morador.getNome();
        String apartamentoRetornado = morador.getApartamento();
        
       
        assertEquals(nome, nomeRetornado);
        assertEquals(apartamento, apartamentoRetornado);
    }
} 