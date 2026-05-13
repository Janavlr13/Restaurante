package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Utilizador;
import com.iefp.Restaurante.repository.service.NotificacaoService;
import com.iefp.Restaurante.repository.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class NotificacaoController {

    private final NotificacaoService notificacaoService;
    private final ReservaService reservaService;

    public NotificacaoController(NotificacaoService notificacaoService, ReservaService reservaService) {
        this.notificacaoService = notificacaoService;
        this.reservaService = reservaService;
    }

    @GetMapping("/notificacoes")
    public String listarNotificacoes(Model model,  HttpSession session){

        Utilizador utilizador = (Utilizador) session.getAttribute("UtilizadorLigado");
        if (utilizador == null){
            return "redirect:/login";
        }
        if(!utilizador.getPerfil().equals("GERENTE") &&
                !utilizador.getPerfil().equals("ADMIN") &&
                        !utilizador.getPerfil().equals("FUNCIONARIO")) {
            return "redirect:/login";
        }
        model.addAttribute("utilizador", utilizador);

        model.addAttribute("mensagem", "Lista de Notificações");
        model.addAttribute("lista", notificacaoService.listarNotificacoes());
        model.addAttribute("listaReservas", reservaService.listarReservas());
        return "notificacoes";
    }

    @PostMapping("/notificacoes")
    public String guardarNotificacao(String tipo,
                                       String mensagem,
                                       LocalDateTime dataHora,
                                       Long idReserva){
        notificacaoService.guardarNotificacao(tipo, mensagem, dataHora, idReserva);
        return "redirect:/notificacoes";
    }
}
