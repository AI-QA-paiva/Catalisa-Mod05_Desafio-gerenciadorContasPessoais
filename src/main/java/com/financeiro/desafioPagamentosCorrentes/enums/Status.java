package com.financeiro.desafioPagamentosCorrentes.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum Status {
    AGUARDANDO,
    PAGO,
    VENCIDA
}
