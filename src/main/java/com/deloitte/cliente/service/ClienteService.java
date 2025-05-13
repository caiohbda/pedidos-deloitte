package com.deloitte.cliente.service;

import com.deloitte.cliente.model.dto.ClienteDTO;
import com.deloitte.cliente.model.dto.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO criar(ClienteDTO dto);
    List<ClienteResponseDTO> listarTodos();
    ClienteResponseDTO buscarPorId(Long id);
    ClienteResponseDTO editar(Long id, ClienteDTO dto);
    void deletar(Long id);
}