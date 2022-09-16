package com.financeiro.desafioPagamentosCorrentes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private String nomeCidade;


    //relação na model Cidade, para dizer que muitas cidades para um mesmo estado
    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "codigo")
    private EstadoModel estado_id;

    //relação na model Cidade, para dizer que uma Cidade tem varios endereços
    @JsonIgnore
    @OneToMany(mappedBy = "cidade_id", cascade = CascadeType.ALL)
    private List<EnderecoModel> listaDeEndereco = new ArrayList<>();

}
