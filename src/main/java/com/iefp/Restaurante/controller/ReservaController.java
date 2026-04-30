package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Reserva;
import com.iefp.Restaurante.repository.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/reservas")
    public String listarReservas(Model model) {
        model.addAttribute("mensagem", "Reservas realizadas");
        model.addAttribute("lista", reservaService.listarReservas());
        return "reservas";
    }

    @PostMapping("/reservas")
    public String guardarReserva(@RequestParam LocalDate data,
                                 @RequestParam LocalTime hora,
                                 @RequestParam Integer numPessoas,
                                 @RequestParam String estado) {
        Reserva reserva = new Reserva(null, data, hora, numPessoas, estado, null, null, null, null, null);
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas";
    }

}
