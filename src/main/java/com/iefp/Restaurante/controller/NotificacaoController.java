package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.repository.service.NotificacaoService;
import com.iefp.Restaurante.repository.service.ReservaService;
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
    public String listarNotificacoes(Model model){
        model.addAttribute("mensagem", "Lista de Notificações");
        model.addAttribute("lista", notificacaoService.listarNotificacoes());
        model.addAttribute("reservas", reservaService.listarReservas());
        return "notificacoes";
    }

    @PostMapping("/notificacoes")
    public String guardarNotificacao(String tipo,
                                       String mensagem,
                                       LocalDateTime dataHora,
                                       Long id_reserva){
        notificacaoService.guardarNotificacao(tipo, mensagem, dataHora, id_reserva);
        return "redirect:/notificacoes";
    }
}
