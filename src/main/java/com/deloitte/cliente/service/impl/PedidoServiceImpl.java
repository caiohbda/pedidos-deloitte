package com.deloitte.cliente.service.impl;

import com.deloitte.cliente.model.dto.PedidoDTO;
import com.deloitte.cliente.model.dto.ProdutoDTO;
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

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository,
                             ClienteRepository clienteRepository,
                             ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public PedidoDTO criar(PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (dto.produtos() == null || dto.produtos().isEmpty()) {
            throw new RuntimeException("A lista de produtos não pode ser nula ou vazia");
        }

        List<Long> produtoIds = dto.produtos().stream()
                .map(ProdutoDTO::id)
                .collect(Collectors.toList());

        List<Produto> produtos = produtoRepository.findAllById(produtoIds);

        if (produtos.isEmpty()) {
            throw new RuntimeException("Produtos não encontrados");
        }

        Pedido pedido = PedidoFactory.fromDTO(dto, cliente, produtos);
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
        return PedidoFactory.fromEntity(pedido);
    }

    @Override
    public PedidoDTO editar(Long id, PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (dto.produtos() == null || dto.produtos().isEmpty()) {
            throw new RuntimeException("A lista de produtos não pode ser nula ou vazia");
        }

        List<Long> produtoIds = dto.produtos().stream()
                .map(ProdutoDTO::id)
                .collect(Collectors.toList());

        List<Produto> produtos = produtoRepository.findAllById(produtoIds);



        if (produtos.isEmpty()) {
            throw new RuntimeException("Produtos não encontrados");
        }

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        pedido.setCliente(cliente);
        pedido.setProdutos(produtos);

        Pedido atualizado = pedidoRepository.save(pedido);
        return PedidoFactory.fromEntity(atualizado);
    }

    @Override
    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}
