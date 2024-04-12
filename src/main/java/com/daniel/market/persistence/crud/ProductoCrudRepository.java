package com.daniel.market.persistence.crud;

import com.daniel.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { //Recibe tabla y su PK

    //@Query(value="SELECT * FROM productos WHERE id_categoria=?", nativeQuery = true);//de forma nativa

    List<Producto> findByIdCategoria(int idCategoria);//con query methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
