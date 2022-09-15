package com.financeiro.desafioPagamentosCorrentes.exception.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.exception.model.ContaReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelAdiantado implements CalculadoraAluguel{

    @Override
    public BigDecimal calcular(ContaReceberModel receberModel) {
        BigDecimal descontoSobreAluguel = receberModel.getValorRecebido().multiply(new BigDecimal("0.05"));
        return receberModel.getValorRecebido().subtract(descontoSobreAluguel);
    }
}
