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
    private Long id;
    private String nome;
    private String contato;
    private String email;
    private LocalDate dataNascimento;

    private List<Reserva> reservas;
}

/*
Cliente - idCliente, nome, contacto
Reserva - idReserva, data, hora, numPessoas, estado
Mesa - idMesa, numeroMesa, capacidade, situacao
Funcionário - idFuncionario, nome, cargo
Gerente - idGerente, nome
Notificação - idNotificacao, tipo, mensagem, dataHora
 */