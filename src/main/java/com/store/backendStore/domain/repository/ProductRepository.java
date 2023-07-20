package com.store.backendStore.domain.repository;

import com.store.backendStore.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository{
    List<Product> getAllProducts();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
