package com.condominio.repository;

import com.condominio.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByMoradorId(Long moradorId);
    List<Veiculo> findByAprovado(boolean aprovado);
} 