package com.shashank.ecommerce.model.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	private String userId;
	private List<ProductInfo> productList = new ArrayList<>();
	private Long addressId;
}
