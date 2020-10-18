package com.shashank.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashank.ecommerce.model.database.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
