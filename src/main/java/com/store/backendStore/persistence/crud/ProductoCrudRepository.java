package com.store.backendStore.persistence.crud;

import com.store.backendStore.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    /*@Query(value = "select * from productos where id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCat(int idCategoria);*/

    List<Producto> findByIdCategoria(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
