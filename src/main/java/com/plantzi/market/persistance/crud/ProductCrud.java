package com.plantzi.market.persistance.crud;

import com.plantzi.market.persistance.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrud extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryIdOrderByNameAsc(int categoryId);
}
