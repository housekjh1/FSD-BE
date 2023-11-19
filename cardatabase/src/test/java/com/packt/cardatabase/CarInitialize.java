package com.packt.cardatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.Role;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.persistence.CarRepository;
import com.packt.cardatabase.persistence.OwnerRepository;
import com.packt.cardatabase.persistence.UserRepository;

@SpringBootTest
public class CarInitialize {

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private OwnerRepository ownerRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Test
	public void test() {
		Owner owner1 = Owner.builder().firstname("John").lastname("Johnson").build();
		Owner owner2 = Owner.builder().firstname("Mary").lastname("Robinson").build();
		ownerRepo.save(owner1);
		ownerRepo.save(owner2);

		carRepo.save(Car.builder().brand("Ford").model("Mustang").color("Red").registerNumber("ADF-1121").yyyy(2021)
				.price(59000).owner(owner1).build());
		carRepo.save(Car.builder().brand("Nissan").model("Leaf").color("White").registerNumber("SSJ-3002").yyyy(2019)
				.price(29000).owner(owner2).build());
		carRepo.save(Car.builder().brand("Toyota").model("Prius").color("Silver").registerNumber("KKO-0212").yyyy(2020)
				.price(39000).owner(owner2).build());
		
		userRepo.save(new User().builder().username("user")
				.password(encoder.encode("abcd")).role(Role.ROLE_USER).build());
		userRepo.save(new User().builder().username("admin")
				.password(encoder.encode("abcd")).role(Role.ROLE_ADMIN).build());
	}
}
