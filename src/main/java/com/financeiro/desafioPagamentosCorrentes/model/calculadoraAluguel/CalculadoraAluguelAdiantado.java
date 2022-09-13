package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContasReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelAdiantado implements CalculadoraAluguel{

    @Override
    public BigDecimal calcular(ContasReceberModel receberModel) {
        BigDecimal descontoSobreAluguel = receberModel.getValorRecebido().multiply(new BigDecimal("0.05"));
        return receberModel.getValorRecebido().subtract(descontoSobreAluguel);
    }
}
