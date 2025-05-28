package com.condominio.repository;

import com.condominio.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
    List<Visitante> findByMoradorId(Long moradorId);
    List<Visitante> findByAprovado(boolean aprovado);
} 