package com.deloitte.cliente.service;

import com.deloitte.cliente.model.dto.PedidoDTO;
import com.deloitte.cliente.model.dto.ProdutoDTO;
import com.deloitte.cliente.model.entity.Produto;

import java.util.List;

public interface ProdutoService {
    ProdutoDTO cadastrar(ProdutoDTO dto);
    List<ProdutoDTO> listarTodos();
    ProdutoDTO editar(Long id, ProdutoDTO dto);
    ProdutoDTO buscarPorId(Long id);
    void deletar(Long id);
}
