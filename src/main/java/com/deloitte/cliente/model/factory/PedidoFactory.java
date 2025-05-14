package com.deloitte.cliente.model.factory;

import com.deloitte.cliente.model.dto.PedidoDTO;
import com.deloitte.cliente.model.entity.Cliente;
import com.deloitte.cliente.model.entity.Pedido;
import com.deloitte.cliente.model.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class PedidoFactory {

    public static Pedido fromDTO(PedidoDTO dto, Cliente cliente, Produto produto) {
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        return pedido;
    }

    public static PedidoDTO fromEntity(Pedido p) {
        return new PedidoDTO(
                p.getId(),
                p.getProduto().getId(),
                p.getCliente().getId(),
                p.getProduto().getNome(),
                p.getProduto().getValor(),
                p.getCliente().getNome(),
                p.getCliente().getEmail()
        );
    }
}