package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Gerente;
import com.iefp.Restaurante.repository.service.GerenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GerenteController {

    private final GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @GetMapping("/gerentes")
    public String listarGerentes(Model model) {
        model.addAttribute("lista", gerenteService.listarGerentes());
        return "gerentes";
    }

    @PostMapping("/gerentes")
    public String guardarGerentes(Gerente gerente) {
        gerenteService.guardarGerente(gerente);
        return "redirect:/gerentes";
    }
}
