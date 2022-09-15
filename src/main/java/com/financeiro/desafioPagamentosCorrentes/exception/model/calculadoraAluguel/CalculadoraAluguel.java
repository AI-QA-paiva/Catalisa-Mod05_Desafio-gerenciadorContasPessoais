package com.financeiro.desafioPagamentosCorrentes.exception.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.exception.model.ContaReceberModel;

import java.math.BigDecimal;

public interface CalculadoraAluguel {
    BigDecimal calcular(ContaReceberModel contaReceberModel);
}
