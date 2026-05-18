package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    private String contato;
    private String endereco;
    private String email;
    private String cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "funcionario")
    private List<Disponibilidade> disponibilidade;
}
