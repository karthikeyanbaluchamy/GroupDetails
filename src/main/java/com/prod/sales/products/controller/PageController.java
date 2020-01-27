package com.prod.sales.products.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prod.sales.products.model.ProductDetails;
import com.prod.sales.products.service.ProductDetailservice;

@RestController
@RequestMapping("/api")
public class PageController {
	
	private final ProductDetailservice productDetailservice;
	
	@Autowired
	
	public PageController(ProductDetailservice productDetailservice) {
		this.productDetailservice=productDetailservice;
	}
	
	@GetMapping("/prod")
	public ResponseEntity<Page<ProductDetails>> getproducts(@RequestParam(required = false) String items,
			@RequestParam(required = false) String brand, @RequestParam(required = false) String colour,
			@RequestParam(required = false) String size, @RequestParam(required = false) Optional<Integer> pageNo,
			@RequestParam(required = false) Optional<Integer> pageSize) {
		try {
		
		Map<String,String> values=new HashMap<String, String>();
		values.put("items", items);
		values.put("colour", colour);
		values.put("size", size);
		values.put("brand", brand);
		
		return ResponseEntity.ok(productDetailservice.retriveProductDetail(pageNo, pageSize,"prd",values));
		}
		catch (Exception e) {
			// TODO: handle exception
			
			return (ResponseEntity<Page<ProductDetails>>) ResponseEntity.status(HttpStatus.resolve(500));
		}
	}
	

}
