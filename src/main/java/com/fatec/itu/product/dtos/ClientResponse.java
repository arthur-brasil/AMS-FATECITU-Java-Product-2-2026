package com.fatec.itu.product.dtos;

// O CPF não sai na resposta: é dado sensível, só entra pelo ClientRequest
public record ClientResponse(
    Long id,
    String name,
    String email,
    String phone
) {

}
