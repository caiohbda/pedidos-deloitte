package com.deloitte.cliente.service.impl;

import com.deloitte.cliente.model.dto.ClienteDTO;
import com.deloitte.cliente.model.entity.Cliente;
import com.deloitte.cliente.model.factory.ClienteFactory;
import com.deloitte.cliente.repository.ClienteRepository;
import com.deloitte.cliente.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteFactory clienteFactory) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public ClienteDTO criar(ClienteDTO dto) {
        Cliente cliente = ClienteFactory.fromDTO(dto);
        Cliente salvo = clienteRepository.save(cliente);
        return ClienteFactory.fromEntity(salvo);
    }

    @Override
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteFactory::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return ClienteFactory.fromEntity(cliente);
    }

    @Override
    public ClienteDTO editar(Long id, ClienteDTO dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteExistente.setNome(dto.nome());
        clienteExistente.setEmail(dto.email());
        clienteExistente.setPassword(dto.password());

        Cliente atualizado = clienteRepository.save(clienteExistente);
        return ClienteFactory.fromEntity(atualizado);
    }

    @Override
    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
