package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.model.CidadeModel;
import com.financeiro.desafioPagamentosCorrentes.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeModel cadastrarCidade(CidadeModel cidade) {
        return cidadeRepository.save(cidade);
    }

    public List<CidadeModel> buscarTodasAsCidades() {
        return cidadeRepository.findAll();
    }

    public Optional<CidadeModel> buscarCidadeEspecifica(Long codigo) {
        return cidadeRepository.findById(codigo);
    }

    public CidadeModel alterarCidadeEspecifica(CidadeModel cidadePraAlterar) {
        return cidadeRepository.save(cidadePraAlterar);
    }

    public void deletarCidade(Long codigo) {
        cidadeRepository.deleteById(codigo);
    }

}
