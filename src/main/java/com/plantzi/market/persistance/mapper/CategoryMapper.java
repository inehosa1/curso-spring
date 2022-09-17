package com.plantzi.market.persistance.mapper;


import com.plantzi.market.domain.dto.CategoryDto;
import com.plantzi.market.persistance.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toCategoryEntity(CategoryEntity category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryDto(CategoryDto category);

}
