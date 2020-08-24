package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.Purchase;
import com.ecommerce.service.PurchaseService;


@RestController
public class PurchaseController {

	@Autowired
	private PurchaseService service;
	private MultiValueMap<String, String> map;
	
	@PostMapping("/purchase")
	public Purchase addPurchase(@RequestBody Purchase purchase) {
	
		return service.addPurchase(purchase);
	}

	@PutMapping("/purchase")
	public Purchase updatePurchase(@RequestBody Purchase purchase) {
		
		return service.updatePurchase(purchase);
	}
	@GetMapping("/purchase/{id}")
	public ResponseEntity<Purchase> getPurchaseById(@PathVariable int id) {
		 try {
				return new ResponseEntity<>(service.getPurchaseById(id), HttpStatus.OK);
			} catch (BusinessException e) {
				map=new LinkedMultiValueMap<>() ;
				map.add("ErrorMessage", e.getMessage());
				return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
			}
		
	}
	

	@DeleteMapping("/purchase/{id}")
	public void deletePurchaseById(@PathVariable int id) {
		
		service.deletePurchaseById(id);
	}

    @GetMapping("/purchases")
	public List<Purchase> getAllPurchases() {
		
		return service.getAllPurchases();
	}
    
    public List<Purchase> getAllPurchasesByDateofPurchase() {
    	return null;
    }

}
