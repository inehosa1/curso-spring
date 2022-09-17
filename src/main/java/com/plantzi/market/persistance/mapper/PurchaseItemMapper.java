package com.plantzi.market.persistance.mapper;

import com.plantzi.market.domain.dto.PurchaseItemDto;
import com.plantzi.market.persistance.entity.PurchaseItemEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId")
    })
    PurchaseItemDto toPurchaseItemEntity(PurchaseItemEntity product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true),
    })
    PurchaseItemEntity toPurchaseItemDto(PurchaseItemDto item);
}
