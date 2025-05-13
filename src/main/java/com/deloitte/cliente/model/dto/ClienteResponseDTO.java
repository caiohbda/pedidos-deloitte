package com.deloitte.cliente.model.dto;

public record ClienteResponseDTO(
        Long id, String nome,
        String email
) {}
