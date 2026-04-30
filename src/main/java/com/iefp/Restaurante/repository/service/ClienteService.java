package com.iefp.Restaurante.repository.service;

import com.iefp.Restaurante.model.Cliente;
import com.iefp.Restaurante.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();

    }

    public void guardar(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
