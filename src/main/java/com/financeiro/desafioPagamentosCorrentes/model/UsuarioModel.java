package com.financeiro.desafioPagamentosCorrentes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    //@NotBlank
    //@NotEmpty(message = "O campo Nome Usuario não pode ser vazio")
    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    //estava reportando erro (porque??) @NotEmpty(message = "Este campo não pode ficar vazio")
    private LocalDate dataNascimento;

    @Column(nullable = false)
    //@NotEmpty(message = "Este campo não pode ficar vazio")
    //@Email
    private String email;

    @Column(nullable = false)
    //@NotEmpty(message = "Este campo não pode ficar vazio")
    //@CPF
    //@Size(min = 11, max = 11, message = "O total de caracteres é de no máximo 11 caracteres")
    private String cpf;

    //relação um usuario tem varias contas a receber
    @JsonIgnore
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<ContaReceberModel> listaDeContasReceber = new ArrayList<>();

    //relação um usuario tem varios endereços
    @JsonIgnore
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<EnderecoModel> litaDeEndereco = new ArrayList<>();

}
