package com.store.backendStore.domain.repository;

import com.store.backendStore.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getPurchaseByClientId(String clientId);
    Purchase save(Purchase purchase);
    boolean delete(int purchaseId);
}
