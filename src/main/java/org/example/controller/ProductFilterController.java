package org.example.controller;

import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductFilterController {

    public ProductFilterController(ProductService productService) {
    }

    @GetMapping("/custom-filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean hasDiscount,
            @RequestParam(required = false) String categoryName,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return null;
    }
}