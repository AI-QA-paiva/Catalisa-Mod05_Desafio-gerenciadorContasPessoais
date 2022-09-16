package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContaReceberModel;

import java.math.BigDecimal;

public class CalculadoraAluguelEmDia implements CalculadoraAluguel {

    @Override
    public BigDecimal calcular(ContaReceberModel contaReceberModel) {

        return contaReceberModel.getValorRecebido();
    }
}
