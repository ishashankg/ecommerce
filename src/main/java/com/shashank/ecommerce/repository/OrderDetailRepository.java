package com.shashank.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashank.ecommerce.model.database.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
