package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product, UriComponentsBuilder uriBuilder) {
        Product productSave = productRepository.save(product);
        URI location = uriBuilder.path("/products/{id}").buildAndExpand(productSave.getId()).toUri();
        return ResponseEntity.created(location).body(productSave);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
}
