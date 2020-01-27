package com.prod.sales.products;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.prod.sales.products.model.ProductDetails;
import com.prod.sales.products.service.ProductDetailservice;

@SpringBootTest
@DataJpaTest
public class ProductsApplicationTests {
	
	@Autowired
	private ProductDetailservice productDetailservice;


	
	 @Test 
	  public void testfind() {
		 
		 Optional<Integer> pageNo=null;
		 Optional<Integer> pageSize=null;
	
			Map<String,String> values=new HashMap<String, String>();
			values.put("items", null);
			values.put("colour", null);
			values.put("size", null);
			values.put("brand", null);
		
		 try {
		Page<ProductDetails> pdetail=	productDetailservice.retriveProductDetail(pageNo, pageSize,"prd",values);
		assertNotNull(pdetail.getContent());
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	

}
