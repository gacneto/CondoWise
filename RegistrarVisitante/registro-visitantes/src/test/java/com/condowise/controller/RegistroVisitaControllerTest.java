package com.condowise.controller;

import com.condowise.model.*;
import com.condowise.service.RegistroVisitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RegistroVisitaControllerTest {

    private RegistroVisitaService service;

    @BeforeEach
    public void setUp() {
        service = new RegistroVisitaService();
        new RegistroVisitaController();
    }

    @Test
    public void testRegistrarVisitante() {
        Morador morador = new Morador("João", "402");
        String nomeVisitante = "Carlos";

        // Registra o visitante
        service.registrarVisitante(nomeVisitante, morador);
        
        // Verifica se o visitante foi registrado corretamente
        List<RegistroVisita> registros = service.getRegistrosEmAndamento();
        assertTrue(registros.stream().anyMatch(r -> r.getVisitante().getNome().equals(nomeVisitante)), 
                   "Visitante não foi registrado corretamente.");
    }

    @Test
    public void testRegistrarEntrada() {
        Morador morador = new Morador("João", "402");
        String nomeVisitante = "Carlos";
        
        // Registra o visitante
        service.registrarVisitante(nomeVisitante, morador);
        
        // Simula a entrada do visitante
        List<RegistroVisita> registros = service.getRegistrosEmAndamento();
        RegistroVisita registro = registros.stream()
                                           .filter(r -> r.getVisitante().getNome().equals(nomeVisitante))
                                           .findFirst()
                                           .orElse(null);
        
        assertNotNull(registro, "Registro do visitante não encontrado.");
        
        // Registra a entrada
        registro.registrarEntrada();
        assertTrue(registro.isEntradaRegistrada(), "Entrada não foi registrada.");
    }

    @Test
    public void testRegistrarSaida() {
        Morador morador = new Morador("João", "402");
        String nomeVisitante = "Carlos";
        
        // Registra o visitante
        service.registrarVisitante(nomeVisitante, morador);
        
        // Simula a entrada e saída do visitante
        List<RegistroVisita> registros = service.getRegistrosEmAndamento();
        RegistroVisita registro = registros.stream()
                                           .filter(r -> r.getVisitante().getNome().equals(nomeVisitante))
                                           .findFirst()
                                           .orElse(null);
        
        assertNotNull(registro, "Registro do visitante não encontrado.");
        
        // Registra a entrada
        registro.registrarEntrada();
        
        // Registra a saída
        registro.registrarSaida();
        assertTrue(registro.isSaidaRegistrada(), "Saída não foi registrada.");
    }
}
