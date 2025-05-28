package com.condominio.repository;

import com.condominio.model.Comunicado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComunicadoRepository extends JpaRepository<Comunicado, Long> {
    List<Comunicado> findAllByOrderByDataPublicacaoDesc();
}