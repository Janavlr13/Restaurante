package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idFuncionario;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    private String email;
    private String cargo;

    private List<Funcionario> funcionario;

    @OneToMany(mappedBy = "idFuncionario")
    private List<Reserva> reserva;
}
