package com.plantzi.market.persistance.mapper;

import com.plantzi.market.domain.dto.ProductDto;
import com.plantzi.market.persistance.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
    })
    ProductDto toProductEntity(ProductEntity product);
    List<ProductDto> toProductsEntity(List<ProductEntity> product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "barcode", ignore = true)
    })
    ProductEntity toProductDto(ProductDto product);

}
