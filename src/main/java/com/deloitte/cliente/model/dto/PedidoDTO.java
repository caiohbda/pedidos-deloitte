package com.deloitte.cliente.model.dto;

import com.deloitte.cliente.model.entity.Cliente;
import com.deloitte.cliente.model.entity.Produto;

import javax.validation.constraints.NotNull;

public record PedidoDTO (
        @NotNull(message = "Obrigatório um produto para realizar o pedido")
        Produto produto,

        @NotNull(message = "Obrigatório vincular um cliente ao pedido")
        Cliente cliente
) {}
