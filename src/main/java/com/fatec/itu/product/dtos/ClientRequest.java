package com.fatec.itu.product.dtos;

public record ClientRequest(
    String name,
    String email,
    String phone,
    String cpf
) {

}
