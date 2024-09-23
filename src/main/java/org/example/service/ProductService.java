package org.example.service;

import org.example.dto.ProductDTO;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.example.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getTop10BoughtProducts() {
        return productRepository.findTop10ByOrderByNumberOfPurchasesDesc();
    }

    public List<ProductDTO> filterAndSortProducts(
            Double minPrice, Double maxPrice, Boolean onSale, String category,
            String sortBy) {

        List<Product> products = productRepository.filterAndSort(minPrice, maxPrice, onSale, category, sortBy);

        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
}