package com.financeiro.desafioPagamentosCorrentes.repository;

import com.financeiro.desafioPagamentosCorrentes.enums.RecebimentoAlugueis;
import com.financeiro.desafioPagamentosCorrentes.enums.TipoRecebimento;
import com.financeiro.desafioPagamentosCorrentes.model.ContasReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContasReceberModel, Long> {
//    List<ContasReceberModel> findByRecebimentoAlugueis(RecebimentoAlugueis recebimentoAlugueis);
//
//    List<ContasReceberModel> findByTipoRecebimento(TipoRecebimento tipoRecebimento);
}
//PROBLEMA DE NAO CONECTAR O BANCO ESTA AQUI EM REPOSITORY POR CONTA DAS ENUNS