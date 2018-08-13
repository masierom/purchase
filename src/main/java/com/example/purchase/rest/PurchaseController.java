package com.example.purchase.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.purchase.domain.Purchase;
import com.example.purchase.dto.PurchaseRequest;
import com.example.purchase.dto.User;
import com.example.purchase.service.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired
	private PurchaseService service;
	
	@GetMapping("/api/purchase/{userId}")
	public @ResponseBody List<Purchase> listUserPurchases(@PathVariable String userId) {
		return service.getListPurchasesByUserId(userId);
	}
	
	@GetMapping("/api/purchase/{userId}/{purchaseId}")
	public @ResponseBody Purchase getPurchaseByUserId(@PathVariable String userId, @PathVariable String purchaseId) {
		return service.getPurchaseByUserId(userId, purchaseId);
	}
	
	@PostMapping("/api/purchase/{userId}")
	public @ResponseBody Purchase buy(@PathVariable String userId, @RequestBody PurchaseRequest request) {
		return service.buy(userId, request.getProductId(), request.getQuantity());
	}
	
	@GetMapping("/api/purchase/users/{productId}")
	public @ResponseBody List<User> getUsersByProduct(@PathVariable String productId) {
		return service.getListUsersByProductId(productId);
	}
	
	/*@GetMapping("/api/purchase/allPurchase")
	public @ResponseBody List<Purchase> getAllPurchases() {
		return service.getAllPurchases();
	}*/
}
