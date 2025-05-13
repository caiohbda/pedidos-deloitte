package com.deloitte.cliente.model.dto;

import javax.validation.constraints.NotBlank;

public record ClienteDTO (
        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotBlank(message = "Email obrigatório")
        String email,

        @NotBlank(message = "Senha obrigatória")
        String password
) {}
