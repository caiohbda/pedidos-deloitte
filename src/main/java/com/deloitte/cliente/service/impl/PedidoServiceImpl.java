package com.deloitte.cliente.service.impl;

import com.deloitte.cliente.model.dto.PedidoDTO;
import com.deloitte.cliente.model.entity.Cliente;
import com.deloitte.cliente.model.entity.Pedido;
import com.deloitte.cliente.model.entity.Produto;
import com.deloitte.cliente.model.factory.PedidoFactory;
import com.deloitte.cliente.repository.ClienteRepository;
import com.deloitte.cliente.repository.PedidoRepository;
import com.deloitte.cliente.repository.ProdutoRepository;
import com.deloitte.cliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoFactory pedidoFactory;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository,
                             ClienteRepository clienteRepository,
                             ProdutoRepository produtoRepository,
                             PedidoFactory pedidoFactory) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoFactory = pedidoFactory;
    }

    @Override
    public PedidoDTO criar(PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Pedido pedido = PedidoFactory.fromDTO(dto, cliente, produto);
        Pedido salvo = pedidoRepository.save(pedido);

        return PedidoFactory.fromEntity(salvo);
    }

    @Override
    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(PedidoFactory::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return pedidoFactory.fromEntity(pedido);
    }

    @Override
    public PedidoDTO editar(Long id, PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        pedido.setCliente(cliente);
        pedido.setProduto(produto);

        Pedido atualizado = pedidoRepository.save(pedido);
        return pedidoFactory.fromEntity(atualizado);
    }

    @Override
    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}
