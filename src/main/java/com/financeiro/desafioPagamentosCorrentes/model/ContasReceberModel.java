package com.financeiro.desafioPagamentosCorrentes.model;

import com.financeiro.desafioPagamentosCorrentes.enums.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    private String status;

    private String recebimento;

    @NotEmpty(message = "Campo Valor não pode ser nulo ou vazio")
    private BigDecimal valorRecebido;

    @Column(name = "renda_classificada")  // aqui nao pode ficar como "Origem da Renda", daria conflito
    @NotEmpty(message = "Não pode ser vazio ou nulo! Favor escolher entre ALUGUEIS, EMPREGO_CLT, FREELANCER para preencher")
    @Enumerated(EnumType.STRING)
    private TipoRecebimento tipoRecebido;

    @Column(length = 15, nullable = false)
    @NotEmpty(message = "Este campo não pode ficar vazio")
    @Size(min = 10, max = 10, message = "Informe data no formato aaaa-mm-dd")
    private LocalDate dataDeVencimento;

    @Column(length = 15)
    private LocalDate dataDeRecebimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario_id;
}
