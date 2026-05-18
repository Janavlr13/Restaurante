package com.iefp.Restaurante.controller;


import com.iefp.Restaurante.model.Funcionario;
import com.iefp.Restaurante.model.Utilizador;
import com.iefp.Restaurante.repository.service.FuncionarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    public String funcionarios(Model model, HttpSession session) {

        Utilizador utilizador = (Utilizador) session.getAttribute("UtilizadorLigado");
        if (utilizador == null){
            return "redirect:/login";
        }
        if(!utilizador.getPerfil().equals("GERENTE") &&
                !utilizador.getPerfil().equals("ADMIN")) {
            return "redirect:/login";
        }
        model.addAttribute("utilizador", utilizador);

        model.addAttribute("mensagem", "Lista de Funcionários");
        model.addAttribute("lista", funcionarioService.listarFuncionarios());
        return "funcionarios";
    }

    @PostMapping("/funcionarios")
    public String guardarFuncionario(@RequestParam String nome,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento,
                                     @RequestParam String contato,
                                     @RequestParam String endereco,
                                     @RequestParam String email,
                                     @RequestParam String cargo) {
        Funcionario funcionario = new Funcionario(null, nome, dataNascimento, contato, endereco, email, cargo, null, null);
        funcionarioService.guardarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }

}
