package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Funcionario;
import com.iefp.Restaurante.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public void guardarFuncionario(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }
}
