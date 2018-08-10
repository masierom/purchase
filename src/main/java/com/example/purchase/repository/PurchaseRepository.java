package com.example.purchase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.purchase.domain.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, String> {
	public List<Purchase> findByUserId(String userId);
}
