package com.condominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ReservaAreaComumTest {
    
    @Test
    public void deveCriarReservaComSucesso() {
      
        Morador morador = new Morador("Caio", "101");
        String area = "Churrasqueira";
        LocalDate dataReserva = LocalDate.of(2024, 5, 15);
        String observacao = "Reserva para aniversário";
        
        
        ReservaAreaComum reserva = new ReservaAreaComum(morador, area, dataReserva, observacao);
        
       
        assertNotNull(reserva);
        assertEquals(morador, reserva.getMorador());
        assertEquals(area, reserva.getArea());
        assertEquals(dataReserva, reserva.getDataReserva());
        assertEquals(observacao, reserva.getObservacao());
        assertFalse(reserva.isAprovada());
    }
    
    @Test
    public void deveAprovarReserva() {
      
        Morador morador = new Morador("Thiago", "202");
        ReservaAreaComum reserva = new ReservaAreaComum(morador, "Salão de Festas", 
            LocalDate.of(2024, 6, 20), "Festa de casamento");
        
        
        reserva.setAprovada(true);
        
        
        assertTrue(reserva.isAprovada());
    }
    
    @Test
    public void deveAtualizarObservacao() {
        
        Morador morador = new Morador("Pedro Costa", "303");
        ReservaAreaComum reserva = new ReservaAreaComum(morador, "Churrasqueira", 
            LocalDate.of(2024, 7, 10), "Observação inicial");
        String novaObservacao = "Nova observação atualizada";
        
        
        reserva.setObservacao(novaObservacao);
        
        
        assertEquals(novaObservacao, reserva.getObservacao());
    }
} 