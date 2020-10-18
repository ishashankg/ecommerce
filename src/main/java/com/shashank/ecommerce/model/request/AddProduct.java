package com.shashank.ecommerce.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProduct {
	private long productId;
	private long companyId;
	private List<Long> listCategoriesId;
	private String name;
	private double salePrice;
	private double listPrice;
	private String image;
	private String overview;
	private int quantity;
	private String description;
}