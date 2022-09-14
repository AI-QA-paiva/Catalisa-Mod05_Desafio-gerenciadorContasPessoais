package com.financeiro.desafioPagamentosCorrentes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "endereco")

public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    @NotEmpty(message = "Campo deve ser preenchido")
    private String logradouro;

    @Column(nullable = false)
    @NotEmpty(message = "Campo deve ser preenchido")
    private String bairro;

    @Column(nullable = false)
    @NotEmpty(message = "Campo deve ser preenchido")
    private String cep;

    @Column(nullable = false)
    private String pontoReferencia;


    //relaçao muitos endereços para uma mesma cidade
    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "codigo")
    private CidadeModel cidade_id;

    //relação muitos endereços para um unico usario
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario_id;

}
