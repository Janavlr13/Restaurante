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

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_gerente")
    private Gerente gerente;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @OneToMany(mappedBy = "reserva")
    private List<Notificacao> notificacoes;
}
