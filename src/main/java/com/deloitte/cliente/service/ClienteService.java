package com.deloitte.cliente.service;

import com.deloitte.cliente.model.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO criar(ClienteDTO dto);

    List<ClienteDTO> listarTodos();

    ClienteDTO buscarPorId(Long id);

    ClienteDTO editar(Long id, ClienteDTO dto);

    void deletar(Long id);
}