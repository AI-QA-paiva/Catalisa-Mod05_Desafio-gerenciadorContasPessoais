package com.financeiro.desafioPagamentosCorrentes.exception.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.exception.model.ContaReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelEmDia implements CalculadoraAluguel{

    @Override
    public BigDecimal calcular(ContaReceberModel contaReceberModel) {
        return contaReceberModel.getValorRecebido();
    }
}
