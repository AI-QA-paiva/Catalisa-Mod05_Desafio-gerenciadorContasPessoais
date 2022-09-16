package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.enums.Status;
import com.financeiro.desafioPagamentosCorrentes.enums.Tipo;
import com.financeiro.desafioPagamentosCorrentes.model.ContasAPagarModel;
import com.financeiro.desafioPagamentosCorrentes.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ContasAPagarController {
    @Autowired
    private ContasAPagarService contasAPagarService;

    @GetMapping(path = "/contas")
    public ResponseEntity<List<ContasAPagarModel>> buscarTodasAsContas() {
        return ResponseEntity.ok(contasAPagarService.buscarAsContas());
    }

    @GetMapping(path = "/contas/{id}")
    public ResponseEntity<Optional<ContasAPagarModel>> buscarContaEspecifica(@PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.buscarContaExata(id));
    }

    @GetMapping(path = "/contas/status/{status}")
    public ResponseEntity<List<ContasAPagarModel>> buscarTodasAsContasPorStatus(@PathVariable Status status) {
        return ResponseEntity.ok(contasAPagarService.buscarContasPorStatus(status));
    }

    @GetMapping(path = "/contas/tipo/{tipo}")
    public ResponseEntity<List<ContasAPagarModel>> buscarTodasAsContasPorTipo(@PathVariable Tipo tipo) {
        return ResponseEntity.ok(contasAPagarService.buscarContasPorTipo(tipo));
    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ContasAPagarModel> cadastrarConta(@Valid @RequestBody ContasAPagarModel cadastrando) {
        ContasAPagarModel conta = contasAPagarService.cadastrarContas(cadastrando);
        return new ResponseEntity<>(conta, HttpStatus.CREATED);
    }

    @PutMapping(path = "contas/{idConta}")
    public ResponseEntity<ContasAPagarModel> alterarConta(@RequestBody ContasAPagarModel alterando, @PathVariable Long idConta) {
        alterando.setIdConta(idConta);
        return ResponseEntity.ok(contasAPagarService.alteracaoConta(alterando));
    }

    @DeleteMapping(path = "/contas/{idConta}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long idConta) {
        contasAPagarService.deletarConta(idConta);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        //contasAPagarService.deletarConta(idConta);
    }

}
