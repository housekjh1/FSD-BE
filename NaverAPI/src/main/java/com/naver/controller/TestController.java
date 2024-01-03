package com.naver.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naver.service.NaverService;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private NaverService naverServ;

	@GetMapping("/predict")
	public String testFlaskService(String pool, @RequestParam(value = "date") LocalDate date) {
		LocalDateTime dateTime = date.atStartOfDay();
		return naverServ.getValuesAndSendToFlask(pool, dateTime);
	}
}
