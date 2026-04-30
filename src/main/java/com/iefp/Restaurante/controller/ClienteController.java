package com.iefp.Restaurante.controller;

import com.iefp.Restaurante.model.Cliente;
import com.iefp.Restaurante.repository.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ClienteController {

private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Metodo
    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("mensagem", "Lista de Clientes");
        model.addAttribute("lista", clienteService.listarTodos());
        return "cliente";
    }

    @PostMapping("/clientes")
    public String adicionarClientes(@RequestParam String nome,
                                    @RequestParam String contato,
                                    @RequestParam String email,
                                    @RequestParam LocalDate dataNascimento) {
        Cliente cliente = new Cliente(null, nome, contato, email, dataNascimento, null);
        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }
}
