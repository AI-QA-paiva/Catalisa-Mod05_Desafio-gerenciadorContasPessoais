package com.financeiro.desafioPagamentosCorrentes.repository;

import com.financeiro.desafioPagamentosCorrentes.model.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {
}
