package com.iefp.Restaurante.controller;


import com.iefp.Restaurante.model.Utilizador;
import com.iefp.Restaurante.repository.service.DisponibilidadeService;
import com.iefp.Restaurante.repository.service.FuncionarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;

@Controller
public class DisponibilidadeController {

    private DisponibilidadeService disponibilidadeService;
    private FuncionarioService funcionarioService;

    private DisponibilidadeController(DisponibilidadeService disponibilidadeService,
                                      FuncionarioService funcionarioService) {
        this.disponibilidadeService = disponibilidadeService;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/disponibilidade")
    public String listarDisponibilidade(Model model, HttpSession session) {

        Utilizador utilizador = (Utilizador) session.getAttribute("UtilizadorLigado");
        if (utilizador == null){
            return "redirect:/login";
        }
        if(!utilizador.getPerfil().equals("GERENTE") &&
                !utilizador.getPerfil().equals("ADMIN")) {
            return "redirect:/login";
        }

        model.addAttribute("utilizador", utilizador);

        model.addAttribute("mensagem", "Lista de Disponibilidade");
        model.addAttribute("lista", disponibilidadeService.listarDisponibilidade());
        model.addAttribute("funcionarios", funcionarioService.listarFuncionarios());
        return "disponibilidade";
    }

    @PostMapping("/disponibilidade")
    public String guardarDisponibilidade(String diaDaSemana,
                                         LocalTime horaInicio,
                                         LocalTime horaFim,
                                         Long idFuncionario) {
        disponibilidadeService.guardarDisponibilidade(diaDaSemana, horaInicio, horaFim, idFuncionario);
        return "redirect:/disponibilidade";
    }

}
