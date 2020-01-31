package com.matera.cursoferias.digitalbank.utils;

import java.math.BigDecimal;

import com.matera.cursoferias.digitalbank.dto.request.ClienteRequestDTO;
import com.matera.cursoferias.digitalbank.dto.response.ContaResponseDTO;
import com.matera.cursoferias.digitalbank.enumerator.SituacaoConta;

public class DigitalbankTestUtils {

    public static ClienteRequestDTO criaClienteRequestDTO() {
        return ClienteRequestDTO.builder().bairro("Bairro 1")
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
    }

    public static ContaResponseDTO criaContaResponseDTO() {
        return ContaResponseDTO.builder().idCliente(1L)
                                         .idConta(2L)
                                         .numeroAgencia(1234)
                                         .numeroConta(102030L)
                                         .saldo(BigDecimal.ZERO)
                                         .situacao(SituacaoConta.ABERTA.getCodigo())
                                         .build();
    }

}
