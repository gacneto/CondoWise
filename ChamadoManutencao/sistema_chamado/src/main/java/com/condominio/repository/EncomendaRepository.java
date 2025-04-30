package com.condominio.repository;

import com.condominio.model.Encomenda;
import com.condominio.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
    List<Encomenda> findByMoradorAndRetirada(Morador morador, boolean retirada);
}