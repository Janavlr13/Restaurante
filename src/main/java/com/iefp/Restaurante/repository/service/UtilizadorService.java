package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Utilizador;
import com.iefp.Restaurante.repository.UtilizadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizadorService {

    private final UtilizadorRepository utilizadorRepository;

    public UtilizadorService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    public List<Utilizador> listarUtilizadores(){
        return utilizadorRepository.findAll();
    }

    public void guardarUtilizador(Utilizador utilizador){
        utilizadorRepository.save(utilizador);
    }

    public Utilizador autenticar(String email, String senha){
        return utilizadorRepository.findByEmailAndSenha(email, senha);
    }
}
