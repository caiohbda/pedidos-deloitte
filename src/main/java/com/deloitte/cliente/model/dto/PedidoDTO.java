package com.deloitte.cliente.model.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public record PedidoDTO(
        Long id,
        List<ProdutoDTO> produtos,
        Long clienteId,
        String clienteNome,
        String clienteEmail
) {}
