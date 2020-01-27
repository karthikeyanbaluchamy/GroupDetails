package com.prod.sales.products.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.prod.sales.products.model.ProductDetails;

public interface ProductDetailservice {
	
	Page<ProductDetails>  retriveProductDetail(Optional<Integer> pageNo,Optional<Integer>  pageSize,final String type,Map<String,String> values) throws Exception;

}
