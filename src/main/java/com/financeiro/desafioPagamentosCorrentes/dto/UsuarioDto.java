package com.financeiro.desafioPagamentosCorrentes.dto;

import com.financeiro.desafioPagamentosCorrentes.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
//@AllArgsConstructor

public class UsuarioDto implements Serializable{
    private Long codigo;

    @NotBlank
    @NotEmpty(message = "Preenchimento Obrigatório")
    private String nomeUsuario;

    @NotNull(message = "Preenchimento Obrigatório")
    private LocalDate dataNascimento;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Email(message = "Email inválido! Favor verificar")
    private String email;

    //construtores: primeiro um vazio, segundo um com os get da classe model original
    public UsuarioDto(){

    }

    public UsuarioDto(Long codigo, String nomeUsuario, LocalDate dataNascimento, String email) {
        this.codigo = codigo;
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public UsuarioDto(UsuarioModel obj) {
        codigo = obj.getCodigo();
        nomeUsuario = obj.getNomeUsuario();
        dataNascimento = obj.getDataNascimento();
        email = obj.getEmail();
    }
}
