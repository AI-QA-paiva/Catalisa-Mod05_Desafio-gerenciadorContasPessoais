package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.model.EnderecoModel;
import com.financeiro.desafioPagamentosCorrentes.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(path = "/endereco")
    public ResponseEntity<EnderecoModel> cadastrandoNovoEndereco(@Valid @RequestBody EnderecoModel cadastrando) {
        EnderecoModel enderecoNovo = enderecoService.cadastrarEndereco(cadastrando);
        return new ResponseEntity<>(enderecoNovo, HttpStatus.CREATED);
    }

    @GetMapping(path = "/endereco")
    public ResponseEntity<List<EnderecoModel>> buscarOsEnderecosCadastrados() {
        return ResponseEntity.ok(enderecoService.buscarTodosOsEnderecos());
    }

    @GetMapping(path = "/endereco/{codigo}")
    public ResponseEntity<Optional<EnderecoModel>> buscarEnderecoId(@PathVariable Long codigo) {
        return ResponseEntity.ok((enderecoService.buscarEnderecoEspecifico(codigo)));
    }

    @PutMapping(path = "/endereco/{codigo}")
    public ResponseEntity<EnderecoModel> alterandoUmEnderecoId(@RequestBody EnderecoModel alterando, @PathVariable Long codigo) {
        alterando.setCodigo(codigo);
        return ResponseEntity.ok(enderecoService.alterarEnderecoEspecifico(alterando));
    }

    @DeleteMapping(path = "/endereco/{codigo}")
    public ResponseEntity<Void> deletarUmEnderecoId(@PathVariable Long codigo) {
        enderecoService.deletarEnderecoEspecifico(codigo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
