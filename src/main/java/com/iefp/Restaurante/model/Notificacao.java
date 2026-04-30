package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idNotificacao;
    private String tipo;
    private String mensagem;
    private LocalDate data;
    private LocalTime hora;

    private List<Notificacao> notificacoes;

}

/*
Cliente - idCliente, nome, contacto
Reserva - idReserva, data, hora, numPessoas, estado
Mesa - idMesa, numeroMesa, capacidade, situacao
Funcionário - idFuncionario, nome, cargo
Gerente - idGerente, nome
Notificação - idNotificacao, tipo, mensagem, dataHora
 */