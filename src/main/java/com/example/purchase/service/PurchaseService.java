package com.example.purchase.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.purchase.domain.Purchase;
import com.example.purchase.dto.Product;
import com.example.purchase.dto.User;
import com.example.purchase.repository.PurchaseRepository;

@Service
public class PurchaseService {
	@Autowired
	private PurchaseRepository repository;
	@Autowired
	private CatalogService cs;
	
	public List<Purchase> getListPurchasesByUserId(String userId){
		return repository.findByUserId(userId);
	}
	
	public List<User> getListUsersByProductId(String productId){
		Map<String, User> tmpUser = new HashMap<String, User>();
		
		List<Purchase> purch = repository.findByProductId(productId);
		
		for(Purchase p : purch) {
			User u = new User();
			u.setUserId(p.getUserId());
			
			if(tmpUser.get(u.getUserId()) == null) {
				tmpUser.put(u.getUserId(), u);
			}
		}
		
		return tmpUser.values().stream().collect(Collectors.toList());
	}
	
	public Purchase getPurchaseByUserId(String userId, String purchaseId) {
		return repository.findById(purchaseId).orElse(null);
	}
	
	public Purchase buy(String userId,
			String productId,
			int quantity) {
		Product product = cs.findProduct(productId);
		cs.changeAvailability(productId, quantity);
		
		Purchase p = new Purchase();
		p.setUserId(userId);
		p.setProductId(productId);
		p.setQuantity(quantity);
		p.setProductTitle(product.getTitle());
		p.setProductCategory(product.getCategory());
		p.setPrice(product.getPrice());
		
		return repository.save(p);
	}
	
	/*public List<Purchase> getAllPurchases(){
		return (List<Purchase>) repository.findAll();
	}*/
}
