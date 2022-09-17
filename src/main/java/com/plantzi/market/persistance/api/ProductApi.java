package com.plantzi.market.persistance.api;

import com.plantzi.market.domain.dto.ProductDto;
import com.plantzi.market.domain.repository.ProductRepository;
import com.plantzi.market.persistance.crud.ProductCrud;
import com.plantzi.market.persistance.entity.ProductEntity;
import com.plantzi.market.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductApi implements ProductRepository {
    @Autowired
    private ProductCrud productCrud;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDto> getAll() {
        List<ProductEntity> product = (List<ProductEntity>) productCrud.findAll();
        return mapper.toProductsEntity(product);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        List<ProductEntity> product = productCrud.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsEntity(product));
    }

    @Override
    public Optional<ProductDto> getProduct(int productId){
        return productCrud.findById(productId).map(product -> mapper.toProductEntity(product));
    }

    @Override
    public ProductDto save(ProductDto product) {
        ProductEntity val_product = mapper.toProductDto(product);
        return mapper.toProductEntity(productCrud.save(val_product));
    }

    @Override
    public void delete(int id) {
        productCrud.deleteById(id);
    }
}
