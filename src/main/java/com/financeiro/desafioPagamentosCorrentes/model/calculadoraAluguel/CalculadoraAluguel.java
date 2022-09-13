package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContasReceberModel;

import java.math.BigDecimal;

public interface CalculadoraAluguel{
    BigDecimal calcular(ContasReceberModel contasReceberModel);
}
