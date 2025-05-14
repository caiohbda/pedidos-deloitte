package com.deloitte.cliente.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record ProdutoDTO(
        Long id,

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Positive(message = "Valor deve ser maior que zero")
        double valor
) {}
