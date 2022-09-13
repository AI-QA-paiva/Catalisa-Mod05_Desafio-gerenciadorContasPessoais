package com.financeiro.desafioPagamentosCorrentes.model;

import com.financeiro.desafioPagamentosCorrentes.enums.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "recebimento")
public class ContasReceberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "origem_recebimento")//  -- tem necessidade?  porque posso deixar a coluna nomeada pelo proprio atributo nao posso?
    @Enumerated(EnumType.STRING)
    private String status;

    private String recebimento;

    @NotEmpty
    private BigDecimal valorRecebido;

    @Column(name = "renda_classificada")  // aqui nao pode ficar como "Origem da Renda", daria conflito
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private TipoRecebimento tipoRecebido;

    @Column(length = 15, nullable = false)
    @NotEmpty
    private LocalDate dataDeVencimento;

    @Column(length = 15)
    private LocalDate dataDeRecebimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario_id;
}
