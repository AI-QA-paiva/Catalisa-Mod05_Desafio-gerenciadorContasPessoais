package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContasReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelEmDia implements CalculadoraAluguel{

    @Override
    public BigDecimal calcular(ContasReceberModel contasReceberModel) {
        return contasReceberModel.getValorRecebido();
    }
}
