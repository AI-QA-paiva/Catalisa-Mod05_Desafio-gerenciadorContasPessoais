package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.model.ContasAPagarModel;
import com.financeiro.desafioPagamentosCorrentes.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasAPagarController {
    @Autowired
    private ContasAPagarService contasAPagarService;

    @GetMapping(path = "/contas")
    public List<ContasAPagarModel> buscarTodasAsContas(){
        return contasAPagarService.buscarAsContas();
    }

    @GetMapping(path = "/contas/{idConta}")
    public Optional<ContasAPagarModel> buscarContaEspecifica(@PathVariable Long codigo){
        return contasAPagarService.buscarContaExata(codigo);
    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ContasAPagarModel> cadastrarConta(@RequestBody ContasAPagarModel cadastrando){
        ContasAPagarModel conta = contasAPagarService.cadastrarContas(cadastrando);
        return new ResponseEntity<>(conta, HttpStatus.CREATED);
    }

   @PutMapping(path = "contas/{idConta}")
   public ContasAPagarModel alterarConta(@RequestBody ContasAPagarModel alterando,@PathVariable Long idConta){//, @PathVariable Long idConta
        alterando.setIdConta(idConta);
        return contasAPagarService.alteracaoConta(alterando);//o, idConta
   }

    @DeleteMapping(path = "/contas/{idConta}")
    public void deletarConta(@PathVariable Long idConta){
        contasAPagarService.deletarConta(idConta);
    }



}
