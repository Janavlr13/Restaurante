package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Notificacao;
import com.iefp.Restaurante.model.Reserva;
import com.iefp.Restaurante.repository.NotificacaoRepository;
import com.iefp.Restaurante.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final ReservaRepository reservaRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository,  ReservaRepository reservaRepository) {
        this.notificacaoRepository = notificacaoRepository;
        this.reservaRepository = reservaRepository;
    }

    public void guardarNotificacao(String tipo,
                                   String mensagem,
                                   LocalDateTime dataHora,
                                   Long id_reserva){

        Optional<Reserva> reserva = reservaRepository.findById(id_reserva);

        Notificacao notificacao = new Notificacao();
        notificacao.setTipo(tipo);
        notificacao.setMensagem(mensagem);
        notificacao.setDataHora(dataHora);
        notificacao.setReserva(reserva.get());

        notificacaoRepository.save(notificacao);

    }

    public List<Notificacao> listarNotificacoes(){
        return notificacaoRepository.findAll();
    }



}
