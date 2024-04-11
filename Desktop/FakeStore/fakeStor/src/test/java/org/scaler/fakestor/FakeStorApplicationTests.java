package org.scaler.fakestor;

import org.junit.jupiter.api.Test;
import org.scaler.fakestor.controller.UserController;
import org.scaler.fakestor.dto.UserRequestDTO;
import org.scaler.fakestor.models.Product;
import org.scaler.fakestor.models.User;
import org.scaler.fakestor.projections.ProductWithIdTitlePrice;
import org.scaler.fakestor.repositories.ProductRepository;
import org.scaler.fakestor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class FakeStorApplicationTests {
	public FakeStorApplicationTests(){

	}

	@Test
	void contextLoads() {
	}

}
