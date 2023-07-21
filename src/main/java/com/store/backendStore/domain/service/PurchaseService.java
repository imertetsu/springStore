package com.store.backendStore.domain.service;

import com.store.backendStore.domain.Purchase;
import com.store.backendStore.domain.PurchaseItem;
import com.store.backendStore.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.getAll();
    }
    public Optional<List<Purchase>> getAPurchasesByClientId(String clientId){
        return purchaseRepository.getPurchaseByClientId(clientId);
    }
    public Purchase savePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    public boolean deletePurchase(int id){
        return purchaseRepository.delete(id);
    }

}
