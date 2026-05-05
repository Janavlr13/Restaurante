package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Mesa;
import com.iefp.Restaurante.repository.service.MesaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping("/mesas")
    public String listarMesas(Model model) {
        model.addAttribute("lista", mesaService.listarMesas());
        return "mesas";
    }

    @PostMapping("/mesas")
    public String guardarMesa(Mesa mesa) {
        mesaService.guardarMesa( mesa );
        return "redirect:/mesas";
    }

}
