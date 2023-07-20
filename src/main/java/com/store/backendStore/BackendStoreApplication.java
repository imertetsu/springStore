package com.store.backendStore;

import com.store.backendStore.domain.repository.ProductRepository;
import com.store.backendStore.persistence.ProductoRepository;
import com.store.backendStore.persistence.crud.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendStoreApplication implements CommandLineRunner {

	private ProductoCrudRepository productoCrudRepository;
	@Autowired
	private ProductRepository productRepository;
	public BackendStoreApplication(
			ProductoCrudRepository productoCrudRepository
	){
		this.productoCrudRepository = productoCrudRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(BackendStoreApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola mundo");
		System.out.println(productoCrudRepository.findById(1));
		System.out.println(productRepository.getProduct(2));
	}
}
