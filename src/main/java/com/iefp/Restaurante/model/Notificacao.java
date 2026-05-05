package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


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
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
}