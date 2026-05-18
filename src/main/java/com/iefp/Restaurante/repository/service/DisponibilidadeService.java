package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Disponibilidade;
import com.iefp.Restaurante.model.Funcionario;
import com.iefp.Restaurante.repository.DisponibilidadeRepository;
import com.iefp.Restaurante.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DisponibilidadeService {

    private final DisponibilidadeRepository disponibilidadeRepository;
    private final FuncionarioRepository funcionarioRepository;

    public DisponibilidadeService(DisponibilidadeRepository disponibilidadeRepository,
                                  FuncionarioRepository funcionarioRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void guardarDisponibilidade(String diaDaSemana,
                                       LocalTime horaInicio,
                                       LocalTime horaFim,
                                       Long idFuncionario) {

        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);

        Disponibilidade disponibilidade = new Disponibilidade();
        disponibilidade.setDiaDaSemana( diaDaSemana );
        disponibilidade.setHoraInicio( horaInicio );
        disponibilidade.setHoraFim( horaFim );
        disponibilidade.setFuncionario(funcionario.get());

        disponibilidadeRepository.save(disponibilidade);
    }

    public List<Disponibilidade> listarDisponibilidade() {
        return disponibilidadeRepository.findAll();
    }
}
