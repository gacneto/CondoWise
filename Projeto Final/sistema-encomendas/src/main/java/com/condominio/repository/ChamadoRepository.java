package com.condominio.repository;

import com.condominio.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    List<Chamado> findByMoradorId(Long moradorId);
    List<Chamado> findByAprovado(boolean aprovado);
} 