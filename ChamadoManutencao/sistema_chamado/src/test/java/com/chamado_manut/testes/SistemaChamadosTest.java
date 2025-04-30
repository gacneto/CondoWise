package com.chamado_manut.testes;

import com.chamado_manut.modelo.Morador;
import com.chamado_manut.modelo.StatusChamado;
import com.chamado_manut.modelo.Chamado;
import com.chamado_manut.servico.SistemaChamadosService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaChamadosTest {

    @Test
    void testCriarChamado() {
        SistemaChamadosService service = new SistemaChamadosService();
        Morador morador = new Morador("Carlos", "101");
        service.criarChamado(morador, "Piscina com vazamento");

        assertEquals(1, service.listarChamados().size());
    }

    @Test
    void testAlterarStatusChamado() {
        SistemaChamadosService service = new SistemaChamadosService();
        Morador morador = new Morador("Carlos", "101");
        service.criarChamado(morador, "Piscina com vazamento");
        
        Chamado chamado = service.listarChamados().get(0);
        service.alterarStatusChamado(chamado.getId(), StatusChamado.EM_ANDAMENTO);

        assertEquals(StatusChamado.EM_ANDAMENTO, chamado.getStatus());
    }
}
