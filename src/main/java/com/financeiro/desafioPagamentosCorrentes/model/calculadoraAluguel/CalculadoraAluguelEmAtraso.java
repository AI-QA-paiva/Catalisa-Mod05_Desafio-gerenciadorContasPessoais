package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContaReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelEmAtraso implements CalculadoraAluguel {

    @Override
    public BigDecimal calcular(ContaReceberModel contaReceberModel) {
        BigDecimal taxacaoAtrasoAluguel = contaReceberModel.getValorRecebido().multiply(new BigDecimal("0.035"));
        return contaReceberModel.getValorRecebido().add(taxacaoAtrasoAluguel);

    }
}
