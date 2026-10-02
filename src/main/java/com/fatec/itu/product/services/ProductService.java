package com.fatec.itu.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fatec.itu.product.dtos.ProductRequest;
import com.fatec.itu.product.dtos.ProductResponse;
import com.fatec.itu.product.entities.Product;
import com.fatec.itu.product.mappers.ProductMapper;
import com.fatec.itu.product.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

     public ProductResponse findById(Long id) {
        return repository.findById(id)
                         .map(ProductMapper::toDTO)   
                         .orElseThrow(() -> new EntityNotFoundException());
     
    }

    public List<ProductResponse> findAll(){
        return repository.findAll()
                         .stream()
                         .map(ProductMapper::toDTO)
                         .toList();
                         
    }

    public void deleteById(long id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
           throw new EntityNotFoundException("Produto não cadastrado");

    }

    public ProductResponse save(ProductRequest product)
    {
         Product p = repository.save(ProductMapper.toEntity(product));
         return ProductMapper.toDTO(p);   
    }

    public void update(ProductRequest product, Long id)
    {
        Product p  = repository.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException("Produto não cadastrado"));

        p.setDescription(product.description());                                
        p.setName(product.name());
        p.setPrice(product.price());

        repository.save(p);


    }
}
