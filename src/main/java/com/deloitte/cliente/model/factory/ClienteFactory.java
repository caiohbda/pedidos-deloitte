package com.deloitte.cliente.model.factory;

import com.deloitte.cliente.model.dto.ClienteDTO;
import com.deloitte.cliente.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteFactory {

    public static Cliente fromDTO(ClienteDTO dto) {
        var cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setPassword(dto.password());
        return cliente;
    }

    public static ClienteDTO fromEntity(Cliente c) {
        return new ClienteDTO(c.getId(), c.getNome(), c.getEmail(), null);
    }
}
