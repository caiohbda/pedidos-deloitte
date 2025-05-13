package com.deloitte.cliente.model.factory;

import com.deloitte.cliente.model.dto.ClienteDTO;
import com.deloitte.cliente.model.dto.PedidoDTO;
import com.deloitte.cliente.model.entity.Cliente;
import com.deloitte.cliente.model.entity.Pedido;

public class PedidoFactory {
    public static Pedido fromDTO(PedidoDTO dto) {
        var pedido = new Pedido();
        pedido.setCliente(dto.cliente());
        pedido.setProduto(dto.produto());
        return pedido;
    }

    public static PedidoDTO fromEntity(Pedido p) {
        return new PedidoDTO(p.getProduto(), p.getCliente());
    }
}
