package com.matera.cursoferias.digitalbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matera.cursoferias.digitalbank.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

}
