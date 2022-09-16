package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContaReceberModel;

import java.math.BigDecimal;

public interface CalculadoraAluguel {
    BigDecimal calcular(ContaReceberModel contaReceberModel);
}
