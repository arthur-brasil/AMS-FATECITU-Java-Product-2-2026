package com.fatec.itu.product.mappers;

import com.fatec.itu.product.dtos.ProductRequest;
import com.fatec.itu.product.dtos.ProductResponse;
import com.fatec.itu.product.entities.Product;

public class ProductMapper {

      public static Product toEntity(ProductRequest request){
            Product p = new Product();
            p.setDescription(request.description());
            p.setName(request.name());
            p.setPrice(request.price());

            return p;
    }

    public static ProductResponse toDTO(Product product)
    {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription()
          
        );
    }
}
