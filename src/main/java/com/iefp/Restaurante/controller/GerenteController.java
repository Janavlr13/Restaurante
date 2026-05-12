package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Gerente;
import com.iefp.Restaurante.repository.service.GerenteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class GerenteController {

    private final GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @GetMapping("/gerentes")
    public String listarGerentes(Model model) {
        model.addAttribute("mensagem", "Lista de Gerentes");
        model.addAttribute("lista", gerenteService.listarGerentes());
        return "gerentes";
    }

    @PostMapping("/gerentes")
    public String guardarGerentes(@RequestParam String nome,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento,
                                  @RequestParam String contato,
                                  @RequestParam String endereco,
                                  @RequestParam String email) {
        Gerente gerente = new Gerente(null, nome, dataNascimento, contato, endereco, email, null);
        gerenteService.guardarGerente(gerente);
        return "redirect:/gerentes";
    }
}
