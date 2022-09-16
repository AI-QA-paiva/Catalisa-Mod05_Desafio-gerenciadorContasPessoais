package com.financeiro.desafioPagamentosCorrentes.model;

import com.financeiro.desafioPagamentosCorrentes.enums.Status;
import com.financeiro.desafioPagamentosCorrentes.enums.Tipo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "contas")

public class ContasAPagarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 10, nullable = false)
    private Double valor;

    @Column(name = "Perfil_da_despesa")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(length = 15, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(length = 15)
    private LocalDateTime dataDePagamento;

    @Column(name = "Situação")
    @Enumerated(EnumType.STRING)
    private Status status;

}
