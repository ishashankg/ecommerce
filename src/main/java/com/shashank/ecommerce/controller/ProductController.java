package com.shashank.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashank.ecommerce.model.database.Product;
import com.shashank.ecommerce.model.request.AddProduct;
import com.shashank.ecommerce.model.response.APIResponse;
import com.shashank.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public ResponseEntity<APIResponse> addProduct(@RequestBody AddProduct productRequest) {
		try {
			return ResponseEntity.ok(productService.addProduct(productRequest));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new APIResponse<Object>("Error adding product", null));
		}
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("categoryId") Long categoryId) {
		return ResponseEntity.ok(productService.getProductsForCategory(categoryId));
	}
}
