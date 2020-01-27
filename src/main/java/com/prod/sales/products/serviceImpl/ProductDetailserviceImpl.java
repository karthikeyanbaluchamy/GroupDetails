package com.prod.sales.products.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.prod.sales.products.model.ProductDetails;
import com.prod.sales.products.repository.ProductDetailsRepository;
import com.prod.sales.products.service.ProductDetailservice;

@Service("ProductDetailservice")
public class ProductDetailserviceImpl implements ProductDetailservice{

	
	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	@Override
	public Page<ProductDetails> retriveProductDetail(Optional<Integer> pageNo, Optional<Integer> pageSize,
			String type,Map<String, String> values) throws Exception {
	
		Specification<ProductDetails> spec=(Root<ProductDetails> root,CriteriaQuery<?> query,CriteriaBuilder CriteriaBuilder ) ->{
		//final long serialVersionUID=1L;
		List<Predicate>  predicates= new ArrayList<>();
		predicates.add(CriteriaBuilder.and(CriteriaBuilder.equal(root.get("type"),type)));
		
		for(Map.Entry<String, String> val:values.entrySet()) {
			
			if(val.getValue()!=null)
				predicates.add(CriteriaBuilder.and(CriteriaBuilder.equal(root.get(val.getKey()), val.getValue())));
		}
		
		return CriteriaBuilder.and(predicates.toArray(new Predicate [predicates.size()]));
		};
				
	  Page<ProductDetails> page = productDetailsRepository.findAll(spec,PageRequest.of(pageNo.orElse(0), pageSize.orElse(3)));	
		return page;
	}

}
