package com.iefp.Restaurante.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Variáveis
    private Long idCliente;
    private String nome;
    private String contato;
    private String email;
    private LocalDate dataNascimento;

    private List<Cliente> cliente;

    @OneToMany (mappedBy = "idCliente")
    private List <Reserva> reserva;
}