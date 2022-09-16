package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.model.CidadeModel;
import com.financeiro.desafioPagamentosCorrentes.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @PostMapping(path = "/cidade")
    public ResponseEntity<CidadeModel> cadastrarCidade(@Valid @RequestBody CidadeModel cadastrandoCidade) {
        CidadeModel cidadeNova = cidadeService.cadastrarCidade(cadastrandoCidade);
        return new ResponseEntity<>(cidadeNova, HttpStatus.CREATED);
    }

    @GetMapping(path = "/cidade")
    public ResponseEntity<List<CidadeModel>> buscarAsCidadesCadastradas() {
        return ResponseEntity.ok(cidadeService.buscarTodasAsCidades());
    }

    @GetMapping(path = "/cidade/{codigo}")
    public ResponseEntity<Optional<CidadeModel>> buscarUmaCidadeEspecifica(@PathVariable Long codigo) {
        return ResponseEntity.ok(cidadeService.buscarCidadeEspecifica(codigo));
    }

    @PutMapping(path = "/cidade/{codigo}")
    public ResponseEntity<CidadeModel> alterandoUmaCidadeEspecifica(@RequestBody CidadeModel alterandoACidade, @PathVariable Long codigo) {
        alterandoACidade.setCodigo(codigo); //revisar esse item
        return ResponseEntity.ok(cidadeService.alterarCidadeEspecifica(alterandoACidade));
    }

    @DeleteMapping(path = "/cidade/{codigo}")
    public ResponseEntity<Void> deletarCidadeIndicada(@PathVariable Long codigo) {
        cidadeService.deletarCidade(codigo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
