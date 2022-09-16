package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.model.EstadoModel;
import com.financeiro.desafioPagamentosCorrentes.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @PostMapping(path = "/estado")
    public ResponseEntity<EstadoModel> cadastrandoNovoEstado(@Valid @RequestBody EstadoModel cadastrando){
        EstadoModel novoEstado = estadoService.cadastrarEstado(cadastrando);
        return new ResponseEntity<>(novoEstado, HttpStatus.CREATED);
    }

    @GetMapping(path = "/estado")
    public ResponseEntity<List<EstadoModel>> buscarOsEstadosCadastrados(){
        return ResponseEntity.ok(estadoService.buscarTodosOsEstados());
    }

    @GetMapping("/estado/{codigo}")
    public ResponseEntity<Optional<EstadoModel>> buscarUmEstadoId(@PathVariable Long codigo){
        return ResponseEntity.ok(estadoService.buscarEstadoEspecifico(codigo));
    }

    @PutMapping("/estado/{codigo}")
    public ResponseEntity<EstadoModel> alterarUmEstadoId(@RequestBody EstadoModel alterandoUmEstado, @PathVariable Long codigo){
        alterandoUmEstado.setCodigo(codigo);
        return ResponseEntity.ok(estadoService.alterarEstadoEspecifico(alterandoUmEstado));
    }

    @DeleteMapping("/estado/{codigo}")
    public ResponseEntity<Void> deletarUmEstadoId(@PathVariable Long codigo){
        estadoService.deletarEstadoEspecifico(codigo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
