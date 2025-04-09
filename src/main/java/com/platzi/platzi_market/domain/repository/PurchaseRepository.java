package com.platzi.platzi_market.domain.repository;

import com.platzi.platzi_market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clienteId);
    Purchase save(Purchase purchase);
}
