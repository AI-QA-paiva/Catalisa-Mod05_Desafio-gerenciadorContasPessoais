package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.model.EstadoModel;
import com.financeiro.desafioPagamentosCorrentes.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public EstadoModel cadastrarEstado(EstadoModel estadoModel) {
        return estadoRepository.save(estadoModel);
    }

    public List<EstadoModel> buscarTodosOsEstados() {
        return estadoRepository.findAll();
    }

    public Optional<EstadoModel> buscarEstadoEspecifico(Long codigo) {
        return estadoRepository.findById(codigo);
    }

    public EstadoModel alterarEstadoEspecifico(EstadoModel alterandoEstado) {
        return estadoRepository.save(alterandoEstado);
    }

    public void deletarEstadoEspecifico(Long codigo) {
        estadoRepository.deleteById(codigo);
    }

}
