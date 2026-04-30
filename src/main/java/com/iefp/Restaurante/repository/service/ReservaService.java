package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Reserva;
import com.iefp.Restaurante.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public void guardarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

}
