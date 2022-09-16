package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.enums.RecebimentoAlugueis;
import com.financeiro.desafioPagamentosCorrentes.enums.Status;
import com.financeiro.desafioPagamentosCorrentes.enums.TipoRecebimento;
import com.financeiro.desafioPagamentosCorrentes.model.ContaReceberModel;
import com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel.CalculadoraAluguel;
import com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel.CalculadoraAluguelFactory;
import com.financeiro.desafioPagamentosCorrentes.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContasReceberService {
    @Autowired
    private ContasReceberRepository contasReceberRepository;

    @Autowired
    private CalculadoraAluguelFactory calculadoraAluguelFactory;

    public ContaReceberModel cadastrarRecebimento(ContaReceberModel recebimento) {

        if(recebimento.getStatus().equals(Status.AGUARDANDO)){ //||recebimento.getStatus().equals(Status.VENCIDA))
            return contasReceberRepository.save(recebimento);

        } else if (recebimento.getStatus().equals((Status.VENCIDA))) {
            RecebimentoAlugueis recebimentoAlugueis = calculadoraAluguelFactory.recebimentoAlugueis(recebimento.getDataDeVencimento(), recebimento.getDataDeRecebimento());
            recebimento.setRecebimentoAlugueis(recebimentoAlugueis);
            return contasReceberRepository.save(recebimento);
        }else if (recebimento.getStatus().equals(Status.PAGO)) {
            recebimento.setDataDeRecebimento(LocalDate.now());
            if (recebimento.getTipoRecebido().equals(TipoRecebimento.ALUGUEIS)) {

                CalculadoraAluguel calculadoraAluguel = calculadoraAluguelFactory.getCalculadoraAluguel(recebimento);
                recebimento.setValorAReceber(calculadoraAluguel.calcular(recebimento)); //setValorRecebido(calculadoraAluguel.calcular(recebimento));
            }
        } else {
            recebimento.setDataDeRecebimento(null);

        }

        RecebimentoAlugueis recebimentoAlugueis = calculadoraAluguelFactory.recebimentoAlugueis(recebimento.getDataDeVencimento(), recebimento.getDataDeRecebimento());
        recebimento.setRecebimentoAlugueis(recebimentoAlugueis);

        return contasReceberRepository.save(recebimento);
    }

    public List<ContaReceberModel> buscarTodosOsRecebimentos() {
        return contasReceberRepository.findAll();
    }

    public Optional<ContaReceberModel> buscarRecebimentoEspecifico(Long codigo) {
        return contasReceberRepository.findById(codigo);
    }

    public ContaReceberModel alterarRecimentoEspecifico(ContaReceberModel alterandoRecebimento) {
        return contasReceberRepository.save(alterandoRecebimento);
    }

    public void deletarRecebimentoEspecifico(Long codigo) {
        contasReceberRepository.deleteById(codigo);
    }

}
