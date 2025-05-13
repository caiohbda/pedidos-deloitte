package com.deloitte.cliente.service.impl;

import com.deloitte.cliente.model.dto.PedidoDTO;
import com.deloitte.cliente.service.PedidoService;

import java.util.List;

public class PedidoServiceImpl implements PedidoService {
    @Override
    public PedidoDTO criar(PedidoDTO dto) {
        return null;
    }

    @Override
    public List<PedidoDTO> listarTodos() {
        return List.of();
    }

    @Override
    public PedidoDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public PedidoDTO editar(Long id, PedidoDTO dto) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }
}
