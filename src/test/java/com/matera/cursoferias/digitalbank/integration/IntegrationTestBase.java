package com.matera.cursoferias.digitalbank.integration;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import com.matera.cursoferias.digitalbank.repository.ClienteRepository;
import com.matera.cursoferias.digitalbank.repository.ContaRepository;
import com.matera.cursoferias.digitalbank.repository.EstornoRepository;
import com.matera.cursoferias.digitalbank.repository.LancamentoRepository;
import com.matera.cursoferias.digitalbank.repository.TransferenciaRepository;

public class IntegrationTestBase {

    @Autowired
    protected ClienteRepository clienteRepository;

    @Autowired
    protected ContaRepository contaRepository;

    @Autowired
    protected EstornoRepository estornoRepository;

    @Autowired
    protected LancamentoRepository lancamentoRepository;

    @Autowired
    protected TransferenciaRepository transferenciaRepository;

    @BeforeEach
    public void limpaBase() {
        transferenciaRepository.deleteAll();
        estornoRepository.deleteAll();
        lancamentoRepository.deleteAll();
        contaRepository.deleteAll();
        clienteRepository.deleteAll();
    }

}
