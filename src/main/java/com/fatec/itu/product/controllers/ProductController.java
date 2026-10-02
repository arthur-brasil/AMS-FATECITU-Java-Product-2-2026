package com.fatec.itu.product.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.itu.product.dtos.ProductRequest;
import com.fatec.itu.product.dtos.ProductResponse;
import com.fatec.itu.product.entities.Product;
import com.fatec.itu.product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable long id){
        return ResponseEntity.ok(service.findById(id));
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest product)
    {
        ProductResponse p = service.save(product);
       
        URI location = ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(p.id())
                       .toUri();
        
        return ResponseEntity.created(location).body(p);


    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id,
                                       @RequestBody ProductRequest product)
    {
            service.update(product, id);
            return ResponseEntity.noContent().build();
    }
    
}
