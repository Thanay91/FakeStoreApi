package org.scaler.fakestor;

import org.junit.jupiter.api.Test;
import org.scaler.fakestor.models.Product;
import org.scaler.fakestor.projections.ProductWithIdTitlePrice;
import org.scaler.fakestor.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class FakeStorApplicationTests {
	ProductRepository productRepository;

	@Autowired
	public FakeStorApplicationTests(ProductRepository productRepository){

		this.productRepository = productRepository;
	}

	@Test
	void contextLoads() {
	}
	@Test
	void getDate(){
		List<ProductWithIdTitlePrice> products = productRepository.something();
		for(ProductWithIdTitlePrice p:products){
			System.out.println(p.getId() + " " + p.getPrice());
		}
	}

}
