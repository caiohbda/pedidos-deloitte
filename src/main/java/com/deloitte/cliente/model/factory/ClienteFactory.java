package com.deloitte.cliente.model.factory;

import com.deloitte.cliente.model.dto.ClienteDTO;
import com.deloitte.cliente.model.dto.ClienteResponseDTO;
import com.deloitte.cliente.model.entity.Cliente;

public class ClienteFactory {
    public static Cliente fromDTO(ClienteDTO dto) {
        var cliente = new Cliente();
        cliente.setEmail(dto.email());
        cliente.setNome(dto.nome());
        cliente.setPassword(dto.password());
        return cliente;
    }

    public static ClienteResponseDTO fromEntity(Cliente c) {
        return new ClienteResponseDTO(c.getId() ,c.getNome(), c.getEmail());
    }
}
