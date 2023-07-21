package com.store.backendStore.persistence;

import com.store.backendStore.domain.Purchase;
import com.store.backendStore.domain.repository.PurchaseRepository;
import com.store.backendStore.persistence.crud.ComprasCrudRepository;
import com.store.backendStore.persistence.entity.Compra;
import com.store.backendStore.persistence.entity.ComprasProducto;
import com.store.backendStore.persistence.entity.ComprasProductoPK;
import com.store.backendStore.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComprasRepository implements PurchaseRepository {
    @Autowired
    private ComprasCrudRepository comprasCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) comprasCrudRepository.findAll();
        return purchaseMapper.toPurchaseList(compras);
    }

    @Override
    public Optional<List<Purchase>> getPurchaseByClientId(String clientId) {
        List<Compra> compras = comprasCrudRepository.findByIdCliente(clientId).orElse(null);
        return compras != null
                ? Optional.of(purchaseMapper.toPurchaseList(compras))
                : Optional.empty();
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getComprasProductoList().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchase(comprasCrudRepository.save(compra));
    }

    @Override
    public boolean delete(int purchaseId) {
        comprasCrudRepository.deleteById(purchaseId);
        return false;
    }
}
