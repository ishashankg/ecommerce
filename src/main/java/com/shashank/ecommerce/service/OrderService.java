package com.shashank.ecommerce.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.ecommerce.enums.OrderStatus;
import com.shashank.ecommerce.model.database.Order;
import com.shashank.ecommerce.model.database.OrderDetail;
import com.shashank.ecommerce.model.database.Product;
import com.shashank.ecommerce.model.request.OrderRequest;
import com.shashank.ecommerce.model.request.ProductInfo;
import com.shashank.ecommerce.model.response.APIResponse;
import com.shashank.ecommerce.repository.OrderDetailRepository;
import com.shashank.ecommerce.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailRepository orderDetailRepo;

	public APIResponse<Long> placeOrder(OrderRequest orderRequest) {
		Date createDate = new Date();

		Order order = new Order();
		order.setUserId(orderRequest.getUserId());
		order.setOrderStatus(OrderStatus.PLACED);
		order.setAddressId(orderRequest.getAddressId());
		order.setCreatedAt(createDate);
		order.setUpdatedAt(createDate);
		save(order);
		saveOrderDetails(orderRequest, createDate, order);
		return new APIResponse<Long>("Order placed successfully", order.getOrderId());
	}

	private void saveOrderDetails(OrderRequest orderRequest, Date createDate, Order order) {
		for (ProductInfo productInfo : orderRequest.getProductList()) {
			Product product = productService.getProduct(productInfo.getProductId());
			if (product != null) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderId(order.getOrderId());
				orderDetail.setProductId(product.getProductId());
				orderDetail.setName(product.getName());
				orderDetail.setPrice(product.getSalePrice());
				orderDetail.setQuantity(productInfo.getQuantity());
				orderDetail.setCreatedAt(createDate);
				orderDetailRepo.save(orderDetail);
			}
		}
	}

	public Order save(Order order) {
		return orderRepo.save(order);
	}
}
