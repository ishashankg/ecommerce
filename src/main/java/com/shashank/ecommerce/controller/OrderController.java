package com.shashank.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashank.ecommerce.model.request.OrderRequest;
import com.shashank.ecommerce.model.response.APIResponse;
import com.shashank.ecommerce.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/place")
	public ResponseEntity<APIResponse> placeOrder(OrderRequest orderRequest) {
		try {
			return ResponseEntity.ok(orderService.placeOrder(orderRequest));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new APIResponse<Object>("Error placing order", null));
		}
	}
}
