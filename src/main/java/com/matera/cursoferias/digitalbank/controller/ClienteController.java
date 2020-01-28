package com.matera.cursoferias.digitalbank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matera.cursoferias.digitalbank.dto.request.ClienteRequestDTO;
import com.matera.cursoferias.digitalbank.dto.response.ClienteResponseDTO;
import com.matera.cursoferias.digitalbank.dto.response.ContaResponseDTO;
import com.matera.cursoferias.digitalbank.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ContaResponseDTO> cadastra(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        ContaResponseDTO contaResponseDTO = clienteService.cadastra(clienteRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(contaResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> consultaTodos() {
        List<ClienteResponseDTO> clientes = clienteService.consultaTodos();

        return ResponseEntity.status(HttpStatus.OK)
                             .body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> consultaPorId(@PathVariable("id") Long id) {
        ClienteResponseDTO clienteResponseDTO = clienteService.consulta(id);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(clienteResponseDTO);
    }

    @GetMapping("/{id}/conta")
    public ResponseEntity<ContaResponseDTO> consultaContaPorIdCliente(@PathVariable("id") Long id) {
        ContaResponseDTO contaResponseDTO = clienteService.consultaContaPorIdCliente(id);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(contaResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualiza(@PathVariable("id") Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        clienteService.atualiza(id, clienteRequestDTO);

        return ResponseEntity.noContent()
                             .build();
    }

}
