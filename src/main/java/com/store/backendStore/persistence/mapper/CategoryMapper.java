package com.store.backendStore.persistence.mapper;

import com.store.backendStore.domain.Category;
import com.store.backendStore.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") //le indicamos spring para que se pueda realizar la inyeccion de dependencias
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productoList", ignore = true)
    Categoria toCategoria(Category category);
}
