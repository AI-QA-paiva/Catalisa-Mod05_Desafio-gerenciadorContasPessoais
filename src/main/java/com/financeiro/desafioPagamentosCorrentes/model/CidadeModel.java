package com.financeiro.desafioPagamentosCorrentes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "cidade")

public class CidadeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nomeCidade;


    //relação muitas cidades para um mesmo estado
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoModel estado_id;

    //relação uma Cidade tem varios endereços
    @OneToMany(mappedBy = "cidade_id",cascade = CascadeType.ALL)
    private List<EnderecoModel> listaDeEndereco = new ArrayList<>();

}
