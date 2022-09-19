package com.financeiro.desafioPagamentosCorrentes.controller;

import com.financeiro.desafioPagamentosCorrentes.dto.UsuarioDto;
import com.financeiro.desafioPagamentosCorrentes.model.UsuarioModel;
import com.financeiro.desafioPagamentosCorrentes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    public ResponseEntity<UsuarioModel> cadastrarNovoUsuario(@Valid @RequestBody UsuarioModel cadastrando) {
        UsuarioModel novoUsuario = usuarioService.cadastrarUsuario(cadastrando);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping(path = "/usuario")
    public ResponseEntity<List<UsuarioModel>> buscarOsUsuariosCadastrados() {
        return ResponseEntity.ok(usuarioService.buscarTodosOsUsuarios());
    }

    @GetMapping(path = "/usuario/{codigo}")
    public ResponseEntity<Optional<UsuarioDto>> buscarUmUsuarioId(@PathVariable Long codigo) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioEspecifico(codigo));
    }

    @PutMapping(path = "/usuario/{codigo}")
    public ResponseEntity<UsuarioModel> alterarUmUsuarioId(@RequestBody UsuarioModel alterandoUmUsuario, @PathVariable Long codigo) {
        alterandoUmUsuario.setCodigo(codigo);
        return ResponseEntity.ok(usuarioService.alterarUsuarioEspecifico(alterandoUmUsuario));
    }

    @DeleteMapping(path = "/usuario/{codigo}")
    public ResponseEntity<Void> deletarUmUsuarioId(@PathVariable Long codigo) {
        usuarioService.deletarUsuarioEspecifico(codigo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
