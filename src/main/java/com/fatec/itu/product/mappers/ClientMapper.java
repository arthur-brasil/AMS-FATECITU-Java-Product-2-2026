package com.fatec.itu.product.mappers;

import com.fatec.itu.product.dtos.ClientRequest;
import com.fatec.itu.product.dtos.ClientResponse;
import com.fatec.itu.product.entities.Client;

public class ClientMapper {

    public static Client toEntity(ClientRequest request){
        Client c = new Client();
        c.setName(request.name());
        c.setEmail(request.email());
        c.setPhone(request.phone());
        c.setCpf(request.cpf());

        return c;
    }

    public static ClientResponse toDTO(Client client)
    {
        return new ClientResponse(
            client.getId(),
            client.getName(),
            client.getEmail(),
            client.getPhone()
        );
    }
}
