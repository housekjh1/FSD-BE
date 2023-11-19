package com.packt.cardatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.persistence.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepo;
	
//	@RequestMapping("/cars")
//	public Iterable<Car> getCars() {
//		return carRepo.findAll();
//	}
}
