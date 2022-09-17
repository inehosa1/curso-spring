package com.plantzi.market.persistance.crud;

import com.plantzi.market.persistance.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrud extends CrudRepository<PurchaseEntity, Integer> {
    Optional<List<PurchaseEntity>> findByClientId(String clientId);
}
