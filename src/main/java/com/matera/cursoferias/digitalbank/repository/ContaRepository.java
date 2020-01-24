package com.matera.cursoferias.digitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matera.cursoferias.digitalbank.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
