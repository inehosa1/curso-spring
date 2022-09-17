package com.plantzi.market.domain.repository;

import com.plantzi.market.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDto> getAll();
    Optional<List<ProductDto>> getByCategory(int category);
    Optional<ProductDto> getProduct(int productId);
    ProductDto save(ProductDto product);
    void delete(int productId);
}
