package com.deloitte.cliente.service.impl;

import com.deloitte.cliente.model.dto.ProdutoDTO;
import com.deloitte.cliente.service.ProdutoService;

import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {
    @Override
    public ProdutoDTO cadastrar(ProdutoDTO dto) {
        return null;
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return List.of();
    }

    @Override
    public ProdutoDTO editar(Long id, ProdutoDTO dto) {
        return null;
    }

    @Override
    public ProdutoDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }
}
