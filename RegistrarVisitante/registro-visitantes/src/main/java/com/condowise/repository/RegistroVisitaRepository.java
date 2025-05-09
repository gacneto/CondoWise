package com.condowise.repository;

import com.condowise.model.RegistroVisita;
import com.condowise.model.Morador;
import com.condowise.model.Visitante;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroVisitaRepository {
    private final String arquivo = "registros_visitas.txt";

    public void salvar(RegistroVisita registro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(formatarRegistro(registro));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar registro: " + e.getMessage());
        }
    }

    public List<RegistroVisita> listarTodos() {
        List<RegistroVisita> registros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                registros.add(parsingRegistro(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler registros: " + e.getMessage());
        }
        return registros;
    }

    private String formatarRegistro(RegistroVisita registro) {
        return String.format("Visitante: %s | Morador: %s | Entrada: %s | Saída: %s",
                registro.getVisitante().getNome(),
                registro.getMorador().getNome(),
                registro.getEntrada(),
                registro.getSaida() == null ? "N/A" : registro.getSaida());
    }

    private RegistroVisita parsingRegistro(String linha) {
        String[] partes = linha.split(" \\| ");
        String nomeVisitante = partes[0].split(": ")[1];
        String nomeMorador = partes[1].split(": ")[1];
        String entrada = partes[2].split(": ")[1];
        String saida = partes[3].split(": ")[1];

        Visitante visitante = new Visitante(nomeVisitante);
        Morador morador = new Morador(nomeMorador, saida);
        RegistroVisita registro = new RegistroVisita(visitante, morador);
        registro.setEntrada(LocalDateTime.parse(entrada));
        if (!saida.equals("N/A")) {
            registro.setSaida(LocalDateTime.parse(saida));
        }
        
        return registro;
    }
}
