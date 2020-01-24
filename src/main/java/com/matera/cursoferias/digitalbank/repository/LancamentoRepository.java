package com.matera.cursoferias.digitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matera.cursoferias.digitalbank.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
