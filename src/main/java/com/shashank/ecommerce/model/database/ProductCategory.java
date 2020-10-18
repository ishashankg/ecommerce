package com.shashank.ecommerce.model.database;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_categories")
public class ProductCategory {

	@EmbeddedId
	private ProductCategoryId id;

}
