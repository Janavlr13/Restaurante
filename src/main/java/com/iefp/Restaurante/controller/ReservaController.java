package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.repository.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class ReservaController {

    private final ReservaService reservaService;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;
    private final GerenteService gerenteService;
    private final MesaService mesaService;

    public ReservaController(ReservaService reservaService, ClienteService clienteService, FuncionarioService funcionarioService, GerenteService gerenteService, MesaService mesaService) {
        this.reservaService = reservaService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
        this.gerenteService = gerenteService;
        this.mesaService = mesaService;
    }

    @GetMapping("/reservas")
    public String listarReservas(Model model) {
        model.addAttribute("mensagem", "Lista de Reservas");
        model.addAttribute("lista", reservaService.listarReservas());
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("funcionarios", funcionarioService.listarFuncionarios());
        model.addAttribute("gerentes", gerenteService.listarGerentes());
        model.addAttribute("mesas", mesaService.listarMesas());
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
