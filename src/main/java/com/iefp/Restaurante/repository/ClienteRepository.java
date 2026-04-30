package com.iefp.Restaurante.repository;

import com.iefp.Restaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
