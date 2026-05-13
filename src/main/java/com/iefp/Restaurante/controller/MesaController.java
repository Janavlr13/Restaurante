package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Mesa;
import com.iefp.Restaurante.model.Utilizador;
import com.iefp.Restaurante.repository.service.MesaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping("/mesas")
    public String listarMesas(Model model, HttpSession session) {

        Utilizador utilizador = (Utilizador) session.getAttribute("UtilizadorLigado");
        if (utilizador == null){
            return "redirect:/login";
        }
        if(!utilizador.getPerfil().equals("GERENTE") &&
                !utilizador.getPerfil().equals("ADMIN")) {
            return "redirect:/login";
        }
        model.addAttribute("utilizador", utilizador);

        model.addAttribute("mensagem", "Lista de Mesas");
        model.addAttribute("lista", mesaService.listarMesas());
        return "mesas"; // igual ao nome to ficheiro html
    }

    @PostMapping("/mesas")
    public String adicionarMesa(@RequestParam Integer numeroMesa,
                                @RequestParam Integer capacidade,
                                @RequestParam String situacao) {
        Mesa mesa = new Mesa(null, numeroMesa, capacidade, situacao, null);
        mesaService.guardarMesa( mesa );
        return "redirect:/mesas";
    }
}
