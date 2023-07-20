package com.store.backendStore.persistence;

import com.store.backendStore.domain.Product;
import com.store.backendStore.domain.repository.ProductRepository;
import com.store.backendStore.persistence.crud.ProductoCrudRepository;
import com.store.backendStore.persistence.entity.Producto;
import com.store.backendStore.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }
    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(products -> productMapper.toProducts(products));
    }
    @Override
    public Optional<Product> getProduct(int productId){
        Producto producto = productoCrudRepository.findById(productId).orElse(null);
        return producto != null
                ? Optional.of(productMapper.toProduct(producto))
                : Optional.empty();

        //return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}
