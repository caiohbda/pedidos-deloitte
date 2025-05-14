package com.deloitte.cliente.model.dto;

import javax.validation.constraints.NotNull;

public record PedidoDTO (

        Long id,

        @NotNull(message = "Obrigatório um produto para realizar o pedido")
        Long produtoId,

        @NotNull(message = "Obrigatório vincular um cliente ao pedido")
        Long clienteId,

        String produtoNome,
        Double produtoValor,

        String clienteNome,
        String clienteEmail
) {}
