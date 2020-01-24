package com.matera.cursoferias.digitalbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.matera.cursoferias.digitalbank.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

    @Query("SELECT cli " +
           "FROM   Cliente cli " +
           "WHERE  cli.cpf = :cpf")
    Optional<Cliente> buscaPorCpf(@Param("cpf") String cpf);

    @Query(value = "SELECT cli.* " +
                   "FROM   db_cliente cli " +
                   "WHERE  cli.cpf = :cpf", nativeQuery = true)
    Optional<Cliente> buscaPorCpfNativeQuery(@Param("cpf") String cpf);

}
