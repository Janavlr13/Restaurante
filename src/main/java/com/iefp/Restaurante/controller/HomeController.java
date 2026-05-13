package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Utilizador;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String  home(HttpSession session, Model model) {
        Utilizador utilizador = (Utilizador) session.getAttribute("UtilizadorLigado");

        if (utilizador == null){
            return "redirect:/login";
        }

        model.addAttribute("utilizador", utilizador);


        return "home";
    }



}
