package com.deloitte.cliente.model.factory;

import com.deloitte.cliente.model.dto.PedidoDTO;
import com.deloitte.cliente.model.dto.ProdutoDTO;
import com.deloitte.cliente.model.entity.Cliente;
import com.deloitte.cliente.model.entity.Pedido;
import com.deloitte.cliente.model.entity.Produto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoFactory {

    public static Pedido fromDTO(PedidoDTO dto, Cliente cliente, List<Produto> produtos) {
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProdutos(produtos);
        return pedido;
    }

    public static PedidoDTO fromEntity(Pedido pedido) {
        List<ProdutoDTO> produtoDTOs = pedido.getProdutos().stream()
                .map(produto -> new ProdutoDTO(produto.getId(), produto.getNome(), produto.getValor()))
                .collect(Collectors.toList());

        double valorTotal = Math.round(
                produtoDTOs.stream()
                        .mapToDouble(ProdutoDTO::valor)
                        .sum() * 100.0
        ) / 100.0;

        return new PedidoDTO(
                pedido.getId(),
                produtoDTOs,
                pedido.getCliente().getId(),
                pedido.getCliente().getNome(),
                pedido.getCliente().getEmail(),
                valorTotal
        );
    }
}
