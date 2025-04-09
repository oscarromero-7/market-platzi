package com.platzi.platzi_market.persistence.mapper;

import com.platzi.platzi_market.domain.Category;
import com.platzi.platzi_market.persistence.entity.Categorias;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categorias categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categorias toCategorias(Category category);
}
