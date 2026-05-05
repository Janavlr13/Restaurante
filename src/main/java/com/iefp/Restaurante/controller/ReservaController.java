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
    public String guardarReserva(LocalDate data,
                                 LocalTime hora,
                                 Integer numPessoas,
                                 String estado,
                                 Long id_cliente,
                                 Long id_funcionario,
                                 Long ig_gerente,
                                 Long id_mesa) {
        reservaService.guardarReserva(data, hora, numPessoas, estado, id_cliente, id_funcionario, ig_gerente, id_mesa);
        return "redirect:/reservas";
    }

}
