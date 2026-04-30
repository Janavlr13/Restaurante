package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idGerente;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    private String email;

    @OneToMany(mappedBy="gerente")
    private List<Reserva> reservas;
}
