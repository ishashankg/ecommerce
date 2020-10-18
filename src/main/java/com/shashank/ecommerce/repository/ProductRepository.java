package com.shashank.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashank.ecommerce.model.database.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByProductIdIn(List<Long> productIds);
}
