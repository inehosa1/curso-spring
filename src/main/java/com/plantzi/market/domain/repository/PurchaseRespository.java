package com.plantzi.market.domain.repository;

import com.plantzi.market.domain.dto.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRespository {
    List<PurchaseDto> getAll();
    Optional<List<PurchaseDto>> getByClient(String clientId);
    PurchaseDto save(PurchaseDto purchase);
}
