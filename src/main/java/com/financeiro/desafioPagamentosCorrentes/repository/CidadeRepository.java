package com.financeiro.desafioPagamentosCorrentes.repository;

import com.financeiro.desafioPagamentosCorrentes.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {
}
