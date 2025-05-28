package com.condominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class ComunicadoTest {
    
    @Test
    public void deveCriarComunicadoComSucesso() {
     
        String titulo = "Reunião de Condomínio";
        String mensagem = "Próxima reunião será no dia 15/05";
        String autor = "Síndico João";
        
      
        Comunicado comunicado = new Comunicado(titulo, mensagem, autor);
        
        
        assertNotNull(comunicado);
        assertEquals(titulo, comunicado.getTitulo());
        assertEquals(mensagem, comunicado.getMensagem());
        assertEquals(autor, comunicado.getAutor());
        assertNotNull(comunicado.getDataPublicacao());
    }
    
    @Test
    public void deveRetornarDataPublicacaoCorreta() {
      
        Comunicado comunicado = new Comunicado("Aviso", "Mensagem", "Autor");
        
       
        LocalDateTime dataPublicacao = comunicado.getDataPublicacao();
        
       
        assertNotNull(dataPublicacao);
        assertTrue(dataPublicacao.isBefore(LocalDateTime.now().plusMinutes(1)));
    }
    
    @Test
    public void deveAtualizarMensagemDoComunicado() {
       
        Comunicado comunicado = new Comunicado("Título", "Mensagem antiga", "Autor");
        String novaMensagem = "Nova mensagem atualizada";
        
       
        comunicado.setMensagem(novaMensagem);
        
       
        assertEquals(novaMensagem, comunicado.getMensagem());
    }
} 