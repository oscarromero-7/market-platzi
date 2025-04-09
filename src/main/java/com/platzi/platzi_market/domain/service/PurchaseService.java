package com.platzi.platzi_market.domain.service;


import com.platzi.platzi_market.domain.Purchase;
import com.platzi.platzi_market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private com.platzi.platzi_market.domain.repository.PurchaseRepository purchaseRepository;

    public List<com.platzi.platzi_market.domain.Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<com.platzi.platzi_market.domain.Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public com.platzi.platzi_market.domain.Purchase save(com.platzi.platzi_market.domain.Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}