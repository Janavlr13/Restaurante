package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Gerente;
import com.iefp.Restaurante.repository.GerenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    private final GerenteRepository gerenteRepository;

    public GerenteService(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    public List<Gerente> listarGerentes(){
        return gerenteRepository.findAll();
    }

    public void guardarGerente(Gerente gerente){
        gerenteRepository.save(gerente);
    }

}
