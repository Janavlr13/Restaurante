package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
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
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "reserva")
    private Reserva reserva;
}