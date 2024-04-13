package com.daniel.market.persistence.mapper;

import com.daniel.market.domain.PurchaseItem;
import com.daniel.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses={ProductMapper.class})
public interface PurchasteItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            //@Mapping(source = "total", target = "total"), NO ES NECESARIO DADO QUE SE LLAMAN IGUAL
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="compra",ignore = true),
            @Mapping(target="producto",ignore = true),
            @Mapping(target="id.idCompra",ignore = true)
    })

    ComprasProducto toComprasProducto(PurchaseItem item);
}
