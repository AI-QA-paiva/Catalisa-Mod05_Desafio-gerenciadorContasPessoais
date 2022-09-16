package com.financeiro.desafioPagamentosCorrentes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "estado")

public class EstadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    @NotEmpty(message = "Este campo não pode ficar vazio")
    @Size(min = 2, max = 2)
    private String uf;

    @Column(nullable = false)
    @NotEmpty(message = "Este campo não pode ficar vazio")
    private String nomeEstado;

    //relação na model Estado para dizer que um Estado tem varias cidades
    @JsonIgnore
    @OneToMany(mappedBy = "estado_id", cascade = CascadeType.ALL)
    private List<CidadeModel> listacidades = new ArrayList<>();

}
