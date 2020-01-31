package com.matera.cursoferias.digitalbank.service;

import static com.matera.cursoferias.digitalbank.utils.DigitalbankTestUtils.criaClienteRequestDTO;
import static com.matera.cursoferias.digitalbank.utils.DigitalbankTestUtils.criaContaResponseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.matera.cursoferias.digitalbank.dto.request.ClienteRequestDTO;
import com.matera.cursoferias.digitalbank.dto.response.ContaResponseDTO;
import com.matera.cursoferias.digitalbank.entity.Cliente;
import com.matera.cursoferias.digitalbank.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ContaService contaService;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void cadastraClienteComSucesso() {
        ClienteRequestDTO clienteRequestDTO = criaClienteRequestDTO();
        ContaResponseDTO contaResponseMock = criaContaResponseDTO();

        when(clienteRepository.findByCpf(eq(clienteRequestDTO.getCpf()))).thenReturn(Optional.empty());
        when(contaService.cadastra(any(Cliente.class))).thenReturn(contaResponseMock);

        ContaResponseDTO contaResponseDTO = clienteService.cadastra(clienteRequestDTO);

        verify(clienteRepository).findByCpf(eq(clienteRequestDTO.getCpf()));
        verify(clienteRepository).save(any(Cliente.class));
        verify(contaService).cadastra(any(Cliente.class));
        verifyNoMoreInteractions(clienteRepository);
        verifyNoMoreInteractions(contaService);

        assertEquals(contaResponseMock, contaResponseDTO);
    }

}
