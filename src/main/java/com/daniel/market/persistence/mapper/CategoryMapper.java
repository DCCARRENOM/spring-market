package com.daniel.market.persistence.mapper;

import com.daniel.market.domain.Category;
import com.daniel.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")//para indicar que es un mapeador
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);//vamos a obtener una category a partir de una categoria

    @InheritInverseConfiguration//indica a MapStruct que la conversion es la inversa a la que hicimos antes
    @Mapping(target = "productos", ignore = true)//para decirle que ese atributo no va a ir
    Categoria toCategoria (Category category);
}
