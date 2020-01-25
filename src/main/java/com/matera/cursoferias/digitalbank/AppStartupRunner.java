package com.matera.cursoferias.digitalbank;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.matera.cursoferias.digitalbank.entity.Cliente;
import com.matera.cursoferias.digitalbank.repository.ClienteRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Cliente cliente = new Cliente("Cliente 1",
                                      "01234567890",
                                      4499998877L,
                                      BigDecimal.valueOf(1000),
                                      "Rua Santos Dumont",
                                      123,
                                      null,
                                      "Centro",
                                      "Maringá",
                                      "PR",
                                      "87087087");

        clienteRepository.save(cliente);

        Cliente cliente2 = clienteRepository.findById(cliente.getId()).orElse(null);
        System.out.println("Cliente 2: " + cliente2);

        Cliente cliente3 = clienteRepository.findByCpf(cliente.getCpf()).orElse(null);
        System.out.println("Cliente 3: " + cliente3);

        clienteRepository.delete(cliente2);
        Optional<Cliente> cliente6 = clienteRepository.findById(cliente.getId());
        System.out.println(cliente6.isPresent());
    }

}
