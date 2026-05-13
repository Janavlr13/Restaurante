package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.*;
import com.iefp.Restaurante.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final GerenteRepository gerenteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final MesaRepository mesaRepository;


    public ReservaService(ReservaRepository reservaRepository, ClienteRepository clienteRepository, GerenteRepository gerenteRepository,  FuncionarioRepository funcionarioRepository, MesaRepository mesaRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.gerenteRepository = gerenteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.mesaRepository = mesaRepository;
    }

    public void guardarReserva(LocalDate data,
                               LocalTime hora,
                               Integer numPessoas,
                               String estado,
                               Long idCliente,
                               Long idFuncionario,
                               Long idGerente,
                               Long idMesa) {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        Optional<Gerente> gerente = gerenteRepository.findById(idGerente);
        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
        Optional<Mesa> mesa = mesaRepository.findById(idMesa);

        Reserva reserva = new Reserva();
        reserva.setData(data);
        reserva.setHora(hora);
        reserva.setNumPessoas(numPessoas);
        reserva.setEstado(estado);
        reserva.setCliente(cliente.get());
        reserva.setFuncionario(funcionario.get());
        reserva.setGerente(gerente.get());
        reserva.setMesa(mesa.get());

        reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }



}
