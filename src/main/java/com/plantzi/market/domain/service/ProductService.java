package com.plantzi.market.domain.service;

import com.plantzi.market.domain.dto.ProductDto;
import com.plantzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDto> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public ProductDto save(ProductDto product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
