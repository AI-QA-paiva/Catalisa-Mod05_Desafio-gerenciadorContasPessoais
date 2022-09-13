package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.model.ContasReceberModel;
import com.financeiro.desafioPagamentosCorrentes.service.ContasReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasReceberController {
    @Autowired
    private ContasReceberService contasReceberService;

    @PostMapping(path = "/recebimento")
    public ResponseEntity<ContasReceberModel> cadastrarNovoRecebimento(@RequestBody ContasReceberModel cadastrandoRecebimento){
        ContasReceberModel novoRecebimento = contasReceberService.cadastrarRecebimento(cadastrandoRecebimento);
        return new ResponseEntity<>(novoRecebimento, HttpStatus.CREATED);
    }

    @GetMapping(path = "/recebimento")
    public ResponseEntity<List<ContasReceberModel>> buscarOsValoresRecebidos(){
        return ResponseEntity.ok(contasReceberService.buscarTodosOsRecebimentos());
    }

    @GetMapping(path = "/recebimento/{codigo}")
    public ResponseEntity<Optional<ContasReceberModel>> buscarUmRecebimentoEspecifico(@PathVariable Long codigo){
        return ResponseEntity.ok(contasReceberService.buscarRecebimentoEspecifico(codigo));
    }

    @PutMapping(path = "/recebimento/{codigo}")
    public ResponseEntity<ContasReceberModel> alterarUmRecebimentoId(@RequestBody ContasReceberModel alteraRecebimento, @PathVariable Long codigo){
        alteraRecebimento.setCodigo(codigo);
        return ResponseEntity.ok(contasReceberService.alterarRecimentoEspecifico(alteraRecebimento));
    }

    @DeleteMapping(path = "/recebimento/{codigo}")
    public ResponseEntity<Void> deletarRecebimentoId(@PathVariable Long codigo){
        contasReceberService.deletarRecebimentoEspecifico(codigo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
