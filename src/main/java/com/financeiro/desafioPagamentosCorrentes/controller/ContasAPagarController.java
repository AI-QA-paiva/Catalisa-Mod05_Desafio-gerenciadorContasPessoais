package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.model.ContasAPagarModel;
import com.financeiro.desafioPagamentosCorrentes.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ContasAPagarModel> cadastrarConta(@RequestBody ContasAPagarModel cadastrando){
        return null;
    }



}
