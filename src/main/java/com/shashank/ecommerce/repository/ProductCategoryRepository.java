package com.shashank.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shashank.ecommerce.model.database.ProductCategory;
import com.shashank.ecommerce.model.database.ProductCategoryId;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, ProductCategoryId> {
	@Query("SELECT p FROM ProductCategory p WHERE p.id.categoryId = :categoryId")
	List<ProductCategory> getProductCategoryByCategoryId(@Param("categoryId") Long categoryId);
}
