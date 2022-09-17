package com.plantzi.market.domain.service;


import com.plantzi.market.domain.dto.ProductDto;
import com.plantzi.market.domain.dto.PurchaseDto;
import com.plantzi.market.domain.repository.PurchaseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRespository purchaseRespository;

    public List<PurchaseDto> getAll() {
        return purchaseRespository.getAll();
    }

    public Optional<List<PurchaseDto>> getByClient(String clientId) {
        return purchaseRespository.getByClient(clientId);
    }

    public PurchaseDto save(PurchaseDto purchase) {
        return purchaseRespository.save(purchase);
    }
}
