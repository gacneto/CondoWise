package com.condominio.repository;

import com.condominio.model.Pagamento;
import com.condominio.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByMorador(Morador morador);
    List<Pagamento> findByMoradorAndPago(Morador morador, boolean pago);
    List<Pagamento> findByPago(boolean pago);
} 