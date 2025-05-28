package com.condominio.repository;

import com.condominio.model.ReservaAreaComum;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReservaAreaComumRepository extends JpaRepository<ReservaAreaComum, Long> {
    List<ReservaAreaComum> findByMoradorId(Long moradorId);
    List<ReservaAreaComum> findByDataReserva(LocalDate dataReserva);
    List<ReservaAreaComum> findByAprovadaFalse();
} 