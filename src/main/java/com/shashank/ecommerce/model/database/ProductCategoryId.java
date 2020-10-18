package com.shashank.ecommerce.model.database;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductCategoryId implements Serializable{
	
	private static final long serialVersionUID = 8526616550330792177L;

	@Basic(optional = false)
	@Column(name = "product_id")
	private Long productId;

	@Basic(optional = false)
	@Column(name = "category_id")
	private Long categoryId;
}
