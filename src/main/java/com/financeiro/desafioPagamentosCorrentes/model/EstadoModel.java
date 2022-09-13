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
@Table(name="estado")

public class EstadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String uf;

    private String nomeEstado;

    //relação um Estado tem varias cidades
    @OneToMany(mappedBy = "estado_id",cascade = CascadeType.ALL)
    private List<CidadeModel> listacidades = new ArrayList<>();

}
