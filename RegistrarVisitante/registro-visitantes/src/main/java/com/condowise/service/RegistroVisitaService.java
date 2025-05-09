package com.condowise.service;

import com.condowise.model.*;
import com.condowise.repository.RegistroVisitaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroVisitaService {
    private final RegistroVisitaRepository repository;
    private final List<RegistroVisita> registrosMemoria;

    public RegistroVisitaService() {
        this.repository = new RegistroVisitaRepository();
        this.registrosMemoria = new ArrayList<>();
    }

    public RegistroVisita registrarVisitante(String nomeVisitante, Morador morador) {
        Visitante visitante = new Visitante(nomeVisitante);
        RegistroVisita registro = new RegistroVisita(visitante, morador);
        registrosMemoria.add(registro);
        return registro;
    }

    public void registrarEntrada(RegistroVisita registro) {
        registro.setEntrada(LocalDateTime.now());
    }

    public void registrarSaida(RegistroVisita registro) {
        registro.setSaida(LocalDateTime.now());
        repository.salvar(registro);
        registrosMemoria.remove(registro);
    }

    public List<RegistroVisita> getRegistrosEmAndamento() {
        return registrosMemoria;
    }

    public List<RegistroVisita> getRegistrosPorMorador(Morador morador) {
        List<RegistroVisita> resultado = new ArrayList<>();
        for (RegistroVisita registro : registrosMemoria) {
            if (registro.getMorador().getNome().equals(morador.getNome())) {
                resultado.add(registro);
            }
        }
        return resultado;
    }
    
}
