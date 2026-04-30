package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idReserva;
    private LocalDate data;
    private LocalTime hora;
    private Integer numPessoas;
    private String estado;

    private List<Reserva> reserva;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "idGerente")
    private Gerente gerente;

    @ManyToOne
    @JoinColumn(name = "idMesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name ="idNotificacao")
    private Notificacao notificacao;
}
