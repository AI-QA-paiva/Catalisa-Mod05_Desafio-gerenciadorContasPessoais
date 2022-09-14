package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.model.ContaReceberModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CalculadoraAluguelFactory {

    public CalculadoraAluguel getCalculadoraAluguel(ContaReceberModel contaAReceber){
        if(isAtrasado(contaAReceber.getDataDeVencimento())){
            return new CalculadoraAluguelEmAtraso();
        } else if(isAdiantado(contaAReceber.getDataDeVencimento())) {
            return new CalculadoraAluguelAdiantado();
        } else {
            return new CalculadoraAluguelEmDia();
        }
    }

    private boolean isAtrasado(LocalDate dataVencimento){return dataVencimento.isBefore(LocalDate.now());
    }

    private boolean isAdiantado(LocalDate dataVencimento){return dataVencimento.isAfter(LocalDate.now());
    }

}
