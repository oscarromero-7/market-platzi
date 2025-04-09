package com.platzi.platzi_market.persistence.crud;

import com.platzi.platzi_market.persistence.entity.Compras;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compras,Integer> {
    Optional<List<Compras>> findByIdCliente(String idCliente);
}
