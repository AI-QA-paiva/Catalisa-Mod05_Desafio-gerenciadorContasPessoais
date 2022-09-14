package com.financeiro.desafioPagamentosCorrentes.repository;

import com.financeiro.desafioPagamentosCorrentes.model.ContaReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContaReceberModel, Long> {
//    List<ContasReceberModel> findByRecebimentoAlugueis(RecebimentoAlugueis recebimentoAlugueis);
//
//    List<ContasReceberModel> findByTipoRecebimento(TipoRecebimento tipoRecebimento);
}
//PROBLEMA DE NAO CONECTAR O BANCO ESTA AQUI EM REPOSITORY POR CONTA DAS ENUNS