package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContasReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelEmAtraso implements CalculadoraAluguel{

    @Override
    public BigDecimal calcular(ContasReceberModel contasReceberModel) {
        BigDecimal taxacaoAtrasoAluguel = contasReceberModel.getValorRecebido().multiply(new BigDecimal("0.035"));
        return contasReceberModel.getValorRecebido().add(taxacaoAtrasoAluguel);

    }
}
