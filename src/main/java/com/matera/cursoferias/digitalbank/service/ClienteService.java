package com.matera.cursoferias.digitalbank.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        validaCadastro(clienteRequestDTO);

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

        return clientesResponseDTO;
    }

    @Transactional
    public void atualiza(Long id, ClienteRequestDTO clienteRequestDTO) {
    	validaAtualizacao(id, clienteRequestDTO);

        Cliente clienteAtualizado = requestDTOParaEntidade(clienteRequestDTO, findById(id));

        clienteRepository.save(clienteAtualizado);
    }

    public ContaResponseDTO consultaContaPorIdCliente(Long idCliente) {
	    return contaService.consultaContaPorIdCliente(idCliente);
	}

    private Cliente findById(Long id) {
        return clienteRepository.findById(id)
        						.orElseThrow(() -> new ServiceException("DB-1", id));
    }

    private void validaCadastro(ClienteRequestDTO clienteRequestDTO) {
        if (clienteRepository.findByCpf(clienteRequestDTO.getCpf()).isPresent()) {
            throw new ServiceException("DB-2", clienteRequestDTO.getCpf());
        }
    }

    private void validaAtualizacao(Long id, ClienteRequestDTO clienteRequestDTO) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(clienteRequestDTO.getCpf());

        if (cliente.isPresent() && !cliente.get().getId().equals(id)) {
            throw new ServiceException("DB-2", clienteRequestDTO.getCpf());
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
        return ClienteResponseDTO.builder().bairro(cliente.getBairro())
        								   .cep(cliente.getCep())
        								   .cidade(cliente.getCidade())
        								   .complemento(cliente.getComplemento())
        								   .cpf(cliente.getCpf())
        								   .estado(cliente.getEstado())
        								   .id(cliente.getId())
        								   .logradouro(cliente.getLogradouro())
                                           .nome(cliente.getNome())
                                           .numero(cliente.getNumero())
                                           .rendaMensal(cliente.getRendaMensal())
                                           .telefone(cliente.getTelefone())
                                           .build();
    }

}
