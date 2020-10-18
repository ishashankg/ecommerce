package com.shashank.ecommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.ecommerce.model.database.Product;
import com.shashank.ecommerce.model.database.ProductCategory;
import com.shashank.ecommerce.model.database.ProductCategoryId;
import com.shashank.ecommerce.model.request.AddProduct;
import com.shashank.ecommerce.model.response.APIResponse;
import com.shashank.ecommerce.repository.ProductCategoryRepository;
import com.shashank.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private ProductCategoryRepository productCategoryRepo;

	public APIResponse<Long> addProduct(AddProduct productRequest) {
		Product product = new Product();
		product.setCreatedOn(new Date());
		product.setDescription(productRequest.getDescription());
		product.setListPrice(productRequest.getListPrice());
		product.setName(productRequest.getName());
		product.setQuantity(productRequest.getQuantity());
		product.setSalePrice(productRequest.getSalePrice());
		product.setStatus(Boolean.TRUE);
		product.setUpdatedOn(new Date());
		save(product);
		addProductCategories(productRequest.getListCategoriesId(), product.getProductId());
		return new APIResponse<Long>("Product added successfully", product.getProductId());
	}

	private void addProductCategories(List<Long> categoriesId, Long productId) {
		List<ProductCategory> productCategories = new ArrayList<>();
		for (Long categoryId : categoriesId) {
			ProductCategoryId productCategoryId = new ProductCategoryId();
			ProductCategory productCategory = new ProductCategory();
			productCategoryId.setCategoryId(categoryId);
			productCategoryId.setProductId(productId);
			productCategory.setId(productCategoryId);
			productCategories.add(productCategory);
		}
		productCategoryRepo.saveAll(productCategories);

	}

	public Product save(Product product) {
		return productRepo.save(product);
	}

	public Product getProduct(Long productId) {
		return productRepo.findById(productId).orElse(null);
	}

	public List<Product> getProductsForCategory(Long categoryId) {
		List<ProductCategory> productCategories = productCategoryRepo.getProductCategoryByCategoryId(categoryId);
		List<Long> productIds = productCategories.stream().map(pc -> pc.getId().getProductId())
				.collect(Collectors.toList());
		return productRepo.findByProductIdIn(productIds);
	}
}
