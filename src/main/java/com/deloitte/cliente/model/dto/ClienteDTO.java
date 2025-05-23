package com.deloitte.cliente.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public record ClienteDTO (

        Long id,

        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotBlank(message = "Email obrigatório")
        String email,

        @NotBlank(message = "Senha obrigatória")
        String password

) {}
