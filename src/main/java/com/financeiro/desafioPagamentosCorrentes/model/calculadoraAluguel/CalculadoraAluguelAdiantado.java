package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContaReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelAdiantado implements CalculadoraAluguel {

    @Override
    public BigDecimal calcular(ContaReceberModel receberModel) {
        BigDecimal descontoSobreAluguel = receberModel.getValorRecebido().multiply(new BigDecimal("0.05"));
        return receberModel.getValorRecebido().subtract(descontoSobreAluguel);
    }
}
