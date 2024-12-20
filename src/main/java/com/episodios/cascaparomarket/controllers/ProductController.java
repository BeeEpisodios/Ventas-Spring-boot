package com.episodios.cascaparomarket.controllers;

import com.episodios.cascaparomarket.dtos.ProductDTO;
import com.episodios.cascaparomarket.dtos.TotalProductosDTO;
import com.episodios.cascaparomarket.models.Product;
import com.episodios.cascaparomarket.repositories.ProductRepository;
import com.episodios.cascaparomarket.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @CrossOrigin
    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok(productService.toDto(product)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @CrossOrigin
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.existsById(id) ? ResponseEntity.ok(productRepository.save(product)) : ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/total")
    public List<TotalProductosDTO> totalCompradoPorProducto () {
        return productService.cantidadTotalProductos();
    }
}
