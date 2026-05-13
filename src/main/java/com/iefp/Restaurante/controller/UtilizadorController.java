package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Utilizador;
import com.iefp.Restaurante.repository.service.UtilizadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilizadorController {

    private UtilizadorService utilizadorService;

    public UtilizadorController(UtilizadorService utilizadorService) {
        this.utilizadorService = utilizadorService;
    }

    @GetMapping("/login")
    public String mostrarLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(@RequestParam String email,
                             @RequestParam String senha,
                             HttpSession session,
                             Model model){
        Utilizador utilizador = utilizadorService.autenticar(email, senha);
        if (utilizador != null){
            session.setAttribute("UtilizadorLigado", utilizador);
            return "redirect:/";
        }
        model.addAttribute("erro", "Email ou senha inválidos.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/utilizadores")
    public String listarUtilizadores(Model model, HttpSession session){
        Utilizador utilizadorLogado = (Utilizador) session.getAttribute("UtilizadorLigado");
        model.addAttribute("utilizador", utilizadorLogado);

        model.addAttribute("mensagem", "Lista de Utilizadores");
        model.addAttribute("lista", utilizadorService.listarUtilizadores());
        return "utilizadores";
    }

    @PostMapping("/utilizadores")
    public String adicionarUtilizador(@RequestParam String nome,
                                      @RequestParam String email,
                                      @RequestParam String senha,
                                      @RequestParam String perfil) {
        Utilizador utilizador = new Utilizador(null,  nome, email, senha, perfil);
        utilizadorService.guardarUtilizador(utilizador);
        return "redirect:/utilizadores";
    }
}
