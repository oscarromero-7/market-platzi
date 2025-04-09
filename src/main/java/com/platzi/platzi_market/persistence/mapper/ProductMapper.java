package com.platzi.platzi_market.persistence.mapper;

import com.platzi.platzi_market.domain.Product;
import com.platzi.platzi_market.persistence.entity.Productos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStock",target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria",target = "category")
    })
    Product toProduct(Productos producto);

    List<Product> toProducts(List<Productos> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Productos toProducto(Product product);

}
