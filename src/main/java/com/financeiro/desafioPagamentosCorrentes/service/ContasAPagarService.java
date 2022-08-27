package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.enums.Tipo;
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

    public Optional<ContasAPagarModel> buscarContaExata(Long idConta){
        return contasAPagarRepository.findById(idConta);
    }

    public List<ContasAPagarModel> buscarContasPorStatus(Status status){
        return contasAPagarRepository.findByStatus(status);
    }

    public List<ContasAPagarModel> buscarContasPorTipo(Tipo tipo){
        return contasAPagarRepository.findByTipo(tipo);
    }

    public ContasAPagarModel cadastrarContas(ContasAPagarModel contasAPagarModel){
        Boolean dataDeHoje = LocalDate.now().isAfter(contasAPagarModel.getDataDeVencimento());

        if(Boolean.FALSE.equals(dataDeHoje)){
            contasAPagarModel.setStatus(Status.AGUARDANDO);
        }else{
            contasAPagarModel.setStatus(Status.VENCIDA);
        }
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alteracaoConta(ContasAPagarModel contasAPagarModel){

        ContasAPagarModel contasAPagarModelEncontrado = contasAPagarRepository.findById(contasAPagarModel.getIdConta()).orElse(null);
        if(contasAPagarModelEncontrado==null){
            return null;
        }

        contasAPagarModelEncontrado.setStatus(contasAPagarModel.getStatus());

        if(contasAPagarModelEncontrado.getStatus().equals(Status.PAGO)){
            contasAPagarModelEncontrado.setDataDePagamento(LocalDateTime.now());
        }
        return contasAPagarRepository.save(contasAPagarModelEncontrado);
    }

    public void deletarConta(Long idConta){
        contasAPagarRepository.deleteById(idConta);
    }



}
