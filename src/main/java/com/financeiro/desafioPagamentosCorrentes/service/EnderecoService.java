package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.model.EnderecoModel;
import com.financeiro.desafioPagamentosCorrentes.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoModel cadastrarEndereco(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }

    public List<EnderecoModel> buscarTodosOsEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<EnderecoModel> buscarEnderecoEspecifico(Long codigo) {
        return enderecoRepository.findById(codigo);
    }

    public EnderecoModel alterarEnderecoEspecifico(EnderecoModel alterandoEndereco) {
        return enderecoRepository.save(alterandoEndereco);
    }

    public void deletarEnderecoEspecifico(Long codigo) {
        enderecoRepository.deleteById(codigo);
    }

}
