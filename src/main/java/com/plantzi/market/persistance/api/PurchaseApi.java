package com.plantzi.market.persistance.api;


import com.plantzi.market.domain.dto.PurchaseDto;
import com.plantzi.market.domain.repository.PurchaseRespository;
import com.plantzi.market.persistance.crud.PurchaseCrud;
import com.plantzi.market.persistance.entity.PurchaseEntity;
import com.plantzi.market.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class PurchaseApi  implements PurchaseRespository {

    @Autowired
    private PurchaseCrud purchaseCrud;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseDto> getAll() {
        List<PurchaseEntity> purchase = (List<PurchaseEntity>) purchaseCrud.findAll();
        return mapper.toPurchasesEntity(purchase);
    }

    @Override
    public Optional<List<PurchaseDto>> getByClient(String clientId) {

        return purchaseCrud.findByClientId(clientId)
                .map(purchase -> mapper.toPurchasesEntity(purchase));
    }
    @Override
    public PurchaseDto save(PurchaseDto purchase) {
        PurchaseEntity save_purchase = mapper.toPurchaseDto(purchase);
        save_purchase.getProducts().forEach(product -> product.setPurchase(save_purchase));
        return mapper.toPurchaseEntity(purchaseCrud.save(save_purchase));
    }
}
