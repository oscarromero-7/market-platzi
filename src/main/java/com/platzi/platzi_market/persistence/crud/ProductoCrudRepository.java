package com.platzi.platzi_market.persistence.crud;

import com.platzi.platzi_market.persistence.entity.Productos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository <Productos,Integer> {
    //@Query(value = "Select * from productos where id_categoria = ?", nativeQuery = true)
    List<Productos> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Productos>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);

}
