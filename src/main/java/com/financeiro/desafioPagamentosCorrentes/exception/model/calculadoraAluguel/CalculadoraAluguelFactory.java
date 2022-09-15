package com.financeiro.desafioPagamentosCorrentes.exception.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.enums.RecebimentoAlugueis;
import com.financeiro.desafioPagamentosCorrentes.exception.model.ContaReceberModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CalculadoraAluguelFactory {


    public CalculadoraAluguel getCalculadoraAluguel(ContaReceberModel contaAReceber) {
        if (isAtrasado(contaAReceber.getDataDeVencimento())) {
            return new CalculadoraAluguelEmAtraso();
        } else if (isAdiantado(contaAReceber.getDataDeVencimento())) {
            return new CalculadoraAluguelAdiantado();
        } else {
            return new CalculadoraAluguelEmDia();
        }

    }

    private boolean isAtrasado(LocalDate dataVencimento) {
        return dataVencimento.isBefore(LocalDate.now());
    }

    private boolean isAdiantado(LocalDate dataVencimento) {
        return dataVencimento.isAfter(LocalDate.now());
    }

    public RecebimentoAlugueis recebimentoAlugueis(LocalDate dataDeVencimento, LocalDate dataDeRecebimento) {
        if (dataDeRecebimento.isBefore(dataDeVencimento)) {
            return RecebimentoAlugueis.ADIANTADO;
        } else if (dataDeRecebimento.isEqual(dataDeVencimento)) {
            return RecebimentoAlugueis.EM_DIA;
        } else if (dataDeRecebimento.isAfter(dataDeVencimento)) {
            return RecebimentoAlugueis.EM_ATRASO;
        } else {
            return null;
        }
    }

}
