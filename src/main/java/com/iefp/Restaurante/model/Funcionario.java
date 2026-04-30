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

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    private String email;
    private String cargo;

    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy="funcionario")
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
