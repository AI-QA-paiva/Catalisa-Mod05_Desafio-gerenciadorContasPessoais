package com.financeiro.desafioPagamentosCorrentes.service;

import com.financeiro.desafioPagamentosCorrentes.dto.UsuarioDto;
import com.financeiro.desafioPagamentosCorrentes.model.UsuarioModel;
import com.financeiro.desafioPagamentosCorrentes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> buscarTodosOsUsuarios() {

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioDto> buscarUsuarioEspecifico(Long codigo) {
        //return usuarioRepository.findById(codigo);

        UsuarioModel userEntity = usuarioRepository.findById(codigo).get();
            UsuarioDto objDto = new UsuarioDto(userEntity);
            return Optional.of(objDto);

    }

    public UsuarioModel alterarUsuarioEspecifico(UsuarioModel alterandoUsuario) {
        return usuarioRepository.save(alterandoUsuario);
    }

    public void deletarUsuarioEspecifico(Long codigo) {
        usuarioRepository.deleteById(codigo);
    }

}
