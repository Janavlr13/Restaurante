package com.iefp.Restaurante.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMesa;
    private Integer numeroMesa;
    private Integer capacidade;
    private String situacao;

    private List<Mesa> mesas;

    @OneToMany(mappedBy = "idMesa")
    private List<Reserva> reserva;
}