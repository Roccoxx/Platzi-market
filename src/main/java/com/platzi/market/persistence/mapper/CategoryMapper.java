package com.platzi.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	@Mappings({
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "descripcion", target = "category"),
        @Mapping(source = "estado", target = "active"),
	})
	Category toCategory(Categoria categoria);

    @InheritInverseConfiguration // la conversion es la inversa a la de mappings (nos ahorra tener que definir los mappings devuelta, ya que hace la inversa)
    @Mapping(target = "productos", ignore = true) // category no tiene la lista, entonces si queremos convertirlo a categoria no hay que mapearla
    Categoria toCategoria(Category category);
}