package com.financeiro.desafioPagamentosCorrentes.repository;

import com.financeiro.desafioPagamentosCorrentes.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
