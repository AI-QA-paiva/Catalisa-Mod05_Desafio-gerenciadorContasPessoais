package com.financeiro.desafioPagamentosCorrentes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "endereco")

public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String logradouro;

    private String bairro;

    private String cep;

    private String pontoReferencia;


    //relaçao muitos endereços para uma mesma cidade
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private CidadeModel cidade_id;

    //relação muitos endereços para um unico usario
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private UsuarioModel endereco_id;

}
