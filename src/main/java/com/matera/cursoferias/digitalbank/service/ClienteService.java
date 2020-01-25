package com.matera.cursoferias.digitalbank.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matera.cursoferias.digitalbank.dto.request.ClienteRequestDTO;
import com.matera.cursoferias.digitalbank.dto.response.ClienteResponseDTO;
import com.matera.cursoferias.digitalbank.dto.response.ContaResponseDTO;
import com.matera.cursoferias.digitalbank.entity.Cliente;
import com.matera.cursoferias.digitalbank.exception.ServiceException;
import com.matera.cursoferias.digitalbank.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ContaService contaService;

    public ClienteService(ClienteRepository clienteRepository, ContaService contaService) {
        this.clienteRepository = clienteRepository;
        this.contaService = contaService;
    }

    @Transactional
    public ContaResponseDTO cadastra(ClienteRequestDTO clienteRequestDTO) {
        valida(clienteRequestDTO);

        Cliente cliente = requestDTOParaEntidade(clienteRequestDTO, new Cliente());

        clienteRepository.save(cliente);

        return contaService.cadastra(cliente);
    }

    public ClienteResponseDTO consulta(Long id) {
        Cliente cliente = findById(id);

        return entidadeParaResponseDTO(cliente);
    }

    public List<ClienteResponseDTO> consultaTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponseDTO> clientesResponseDTO = new ArrayList<>();

        clientes.forEach(cli -> clientesResponseDTO.add(entidadeParaResponseDTO(cli)));

        //for (Cliente cliente : clientes) {
        //    clientesResponseDTO.add(entidadeParaResponseDTO(cliente));
        //}

        return clientesResponseDTO;
    }

    public void atualiza(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente clienteAtualizado = requestDTOParaEntidade(clienteRequestDTO, findById(id));

        clienteRepository.save(clienteAtualizado);
    }

    private Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ServiceException("Cliente de ID " + id + " não encontrado."));
    }

    private void valida(ClienteRequestDTO clienteRequestDTO) {
        if (clienteRepository.findByCpf(clienteRequestDTO.getCpf()).isPresent()) {
            throw new ServiceException("Já existe um cliente cadastrado com o CPF informado (" +
                                       clienteRequestDTO.getCpf() + ")");
        }
    }

    private Cliente requestDTOParaEntidade(ClienteRequestDTO clienteRequestDTO, Cliente cliente) {
        cliente.setBairro(clienteRequestDTO.getBairro());
        cliente.setCep(clienteRequestDTO.getCep());
        cliente.setCidade(clienteRequestDTO.getCidade());
        cliente.setComplemento(clienteRequestDTO.getComplemento());
        cliente.setCpf(clienteRequestDTO.getCpf());
        cliente.setEstado(clienteRequestDTO.getEstado());
        cliente.setLogradouro(clienteRequestDTO.getLogradouro());
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setNumero(clienteRequestDTO.getNumero());
        cliente.setRendaMensal(clienteRequestDTO.getRendaMensal());
        cliente.setTelefone(clienteRequestDTO.getTelefone());

        return cliente;
    }

    private ClienteResponseDTO entidadeParaResponseDTO(Cliente cliente) {
        return ClienteResponseDTO.builder().id(cliente.getId())
                                           .nome(cliente.getNome())
                                           .cpf(cliente.getCpf())
                                           .telefone(cliente.getTelefone())
                                           .rendaMensal(cliente.getRendaMensal())
                                           .logradouro(cliente.getLogradouro())
                                           .numero(cliente.getNumero())
                                           .complemento(cliente.getComplemento())
                                           .bairro(cliente.getBairro())
                                           .cidade(cliente.getCidade())
                                           .estado(cliente.getEstado())
                                           .cep(cliente.getCep())
                                           .build();
    }

}
