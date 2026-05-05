package com.iefp.Restaurante.controller;


import com.iefp.Restaurante.model.Funcionario;
import com.iefp.Restaurante.repository.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    public String funcionarios(Model model) {
        model.addAttribute("lista", funcionarioService.listarFuncionarios());
        return "funcionarios";
    }

    @PostMapping("/funcionarios")
    public String guardarFuncionario(Funcionario funcionario) {
        funcionarioService.guardarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }

}
