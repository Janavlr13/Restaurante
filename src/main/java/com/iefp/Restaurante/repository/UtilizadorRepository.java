package com.iefp.Restaurante.repository;

import com.iefp.Restaurante.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {

    Utilizador findByEmailAndSenha(String email, String senha);

}
