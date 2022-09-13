package com.financeiro.desafioPagamentosCorrentes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank
    @NotEmpty
    private String nomeUsuario;

    private LocalDate dataNascimento;

    @Email
    private String email;

    @CPF
    private String cpf;

    //relação um usuario tem varias contas a receber
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<ContasReceberModel> listaDeContasReceber = new ArrayList<>();

    //relação um usuario tem varios endereços
    @OneToMany(mappedBy = "endereco_id",cascade = CascadeType.ALL)
    private List<EnderecoModel> litaDeEndereco = new ArrayList<>();

}
