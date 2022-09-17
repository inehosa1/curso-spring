package com.plantzi.market.persistance.mapper;

import com.plantzi.market.domain.dto.PurchaseDto;
import com.plantzi.market.persistance.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", uses={PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "products", target = "items"),
    })
    PurchaseDto toPurchaseEntity(PurchaseEntity purchase);
    List<PurchaseDto> toPurchasesEntity(List<PurchaseEntity> purchase);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseEntity toPurchaseDto(PurchaseDto purchase);
}
