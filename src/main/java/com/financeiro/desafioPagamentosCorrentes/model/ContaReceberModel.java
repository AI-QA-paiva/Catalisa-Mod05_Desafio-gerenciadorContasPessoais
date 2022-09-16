package com.financeiro.desafioPagamentosCorrentes.model;

import com.financeiro.desafioPagamentosCorrentes.enums.RecebimentoAlugueis;
import com.financeiro.desafioPagamentosCorrentes.enums.Status;
import com.financeiro.desafioPagamentosCorrentes.enums.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "recebimento")
public class ContaReceberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    private String recebimento;

    @Column(nullable = false)
    private BigDecimal valorRecebido; // valor que o usuario irá informar

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoRecebimento tipoRecebido;

    @Column(nullable = false)
    private LocalDate dataDeVencimento;

    //@JsonIgnore
    @Enumerated(EnumType.STRING)
    private RecebimentoAlugueis recebimentoAlugueis;

    @Column
    private LocalDate dataDeRecebimento; // calculado pelo codigo

    private BigDecimal valorAReceber; // valor que sera calculado a partir da checagem de data

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario_id;
}
