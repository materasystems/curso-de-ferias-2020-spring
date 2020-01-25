package com.matera.cursoferias.digitalbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matera.cursoferias.digitalbank.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByNumeroConta(Long numeroConta);

}
