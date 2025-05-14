package com.deloitte.cliente.service;

import com.deloitte.cliente.model.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {
    PedidoDTO criar(PedidoDTO dto);

    List<PedidoDTO> listarTodos();

    PedidoDTO buscarPorId(Long id);

    PedidoDTO editar(Long id, PedidoDTO dto);

    void deletar(Long id);
}
