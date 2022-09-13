package com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel;

import com.financeiro.desafioPagamentosCorrentes.enums.RecebimentoAlugueis;
import org.springframework.stereotype.Component;

@Component
public class CalculadoraAluguelFactory {

    public CalculadoraAluguel calculadoraAluguel(String recebimentoAlugueis){
        if(recebimentoAlugueis.equalsIgnoreCase("em_atraso")){
            return new CalculadoraAluguelEmAtraso();
        } else if(recebimentoAlugueis.equalsIgnoreCase("adiantado")) {
            return new CalculadoraAluguelAdiantado();
        } else if(recebimentoAlugueis.equalsIgnoreCase("em_dia")){
            return new CalculadoraAluguelEmDia();
        } else {
            return null;
        }

    }
}
