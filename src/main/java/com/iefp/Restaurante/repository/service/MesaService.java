package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Mesa;
import com.iefp.Restaurante.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    public void guardarMesa(Mesa mesa) {
        mesaRepository.save(mesa);
    }
}
