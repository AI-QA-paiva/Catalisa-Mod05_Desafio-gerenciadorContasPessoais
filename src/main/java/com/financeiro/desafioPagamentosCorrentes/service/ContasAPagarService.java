package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.model.ContasAPagarModel;
import com.financeiro.desafioPagamentosCorrentes.enums.Status;
import com.financeiro.desafioPagamentosCorrentes.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {
    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public List<ContasAPagarModel> buscarAsContas(){
        return contasAPagarRepository.findAll();
    }

    public Optional<ContasAPagarModel> buscarContaExata(Long codigo){
        return contasAPagarRepository.findById(codigo);
    }

    public ContasAPagarModel cadastrarContas(ContasAPagarModel contasAPagarModel){
        Boolean dataDeHoje = LocalDate.now().isAfter(contasAPagarModel.getDataDeVencimento());

        contasAPagarModel.getIdConta();
        contasAPagarModel.getNome();
        contasAPagarModel.getValor();
        contasAPagarModel.getTipo();
        contasAPagarModel.getDataDeVencimento();

        if(Boolean.FALSE.equals(dataDeHoje)){
            contasAPagarModel.setStatus(Status.VENCIDA);
        }else{
            contasAPagarModel.setStatus(Status.AGUARDANDO);
        }
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alterarConta(ContasAPagarModel contasAPagarModel, Long idConta){
        //LocalDateTime dataDeHoje = LocalDateTime.now();
        contasAPagarModel.getIdConta();
        contasAPagarModel.getTipo();
        //contasAPagarModel.setDataDePagamento();

        //contasAPagarModel.getNomeConta();
        //contasAPagarModel.getValorConta();
        //contasAPagarModel.getDataDeVencimento();

        return contasAPagarRepository.save(contasAPagarModel);
    }

}
