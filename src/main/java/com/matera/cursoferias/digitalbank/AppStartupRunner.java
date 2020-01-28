package com.matera.cursoferias.digitalbank;

import java.math.BigDecimal;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.matera.cursoferias.digitalbank.dto.request.ClienteRequestDTO;
import com.matera.cursoferias.digitalbank.service.ClienteService;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final ClienteService clienteService;

    public AppStartupRunner(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClienteRequestDTO cliente1 = ClienteRequestDTO.builder().bairro("Bairro 1")
                                                                .cep("87087087")
                                                                .cidade("Maringá")
                                                                .complemento(null)
                                                                .cpf("01234567890")
                                                                .estado("PR")
                                                                .logradouro("Rua 1")
                                                                .nome("Cliente 1")
                                                                .numero(123)
                                                                .rendaMensal(BigDecimal.valueOf(5000))
                                                                .telefone(91234567L)
                                                                .build();

        ClienteRequestDTO cliente2 = ClienteRequestDTO.builder().bairro("Bairro 2")
                                                                .cep("87087088")
                                                                .cidade("Maringá")
                                                                .complemento("Casa A")
                                                                .cpf("01234567891")
                                                                .estado("PR")
                                                                .logradouro("Rua 2")
                                                                .nome("Cliente 2")
                                                                .numero(124)
                                                                .rendaMensal(BigDecimal.valueOf(3000))
                                                                .telefone(91234568L)
                                                                .build();

        clienteService.cadastra(cliente1);
        clienteService.cadastra(cliente2);
    }

}
