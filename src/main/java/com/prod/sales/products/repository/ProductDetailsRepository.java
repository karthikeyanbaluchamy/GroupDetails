package com.prod.sales.products.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.prod.sales.products.model.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails,String>,JpaSpecificationExecutor<ProductDetails>{

	
	Page<ProductDetails> findAll(Specification<ProductDetails> specification,Pageable pageable );
}
