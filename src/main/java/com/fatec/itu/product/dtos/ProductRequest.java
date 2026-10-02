package com.fatec.itu.product.dtos;

public record ProductRequest(
    String name,
    String description,
    Double price
) {
    
}
