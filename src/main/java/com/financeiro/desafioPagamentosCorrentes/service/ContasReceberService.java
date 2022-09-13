package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.enums.TipoRecebimento;
import com.financeiro.desafioPagamentosCorrentes.model.ContasReceberModel;
import com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel.CalculadoraAluguel;
import com.financeiro.desafioPagamentosCorrentes.model.calculadoraAluguel.CalculadoraAluguelFactory;
import com.financeiro.desafioPagamentosCorrentes.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContasReceberService {
    @Autowired
    private ContasReceberRepository contasReceberRepository;

    @Autowired
    private CalculadoraAluguelFactory calculadoraAluguelFactory;

    public ContasReceberModel cadastrarRecebimento(ContasReceberModel anotarRecebimento){

        return contasReceberRepository.save(anotarRecebimento);

//        Boolean qualTipoRecebimento = anotarRecebimento.getStatus().equals(TipoRecebimento.ALUGUEIS);
//        if(Boolean.FALSE.equals(qualTipoRecebimento)){
//            return contasReceberRepository.save(anotarRecebimento);
//        }else {
//            CalculadoraAluguel calculadoraAluguel = calculadoraAluguelFactory}

//        esse boolean vai servir para identificar a enum RecebimentoAlugueis
//            Boolean dataAgora = LocalDate.now().isAfter(anotarRecebimento.getDataDeVencimento());
//                if(Boolean.FALSE.equals(dataAgora)){ anotarRecebimento.}

    }

    public List<ContasReceberModel> buscarTodosOsRecebimentos(){
        return contasReceberRepository.findAll();
    }

    public Optional<ContasReceberModel> buscarRecebimentoEspecifico(Long codigo){
        return contasReceberRepository.findById(codigo);
    }

    public ContasReceberModel alterarRecimentoEspecifico(ContasReceberModel alterandoRecebimento){
        return contasReceberRepository.save(alterandoRecebimento);
    }

    public void deletarRecebimentoEspecifico(Long codigo){
        contasReceberRepository.deleteById(codigo);
    }

}
