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

	@GetMapping("/sum")
	public String callFlaskService(@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b) {
		String flaskServiceUrl = "http://localhost:5000/sum?a=" + a + "&b=" + b;
		Map<String, Object> response = restTemplate.getForObject(flaskServiceUrl, Map.class);
		Float result = ((Number) response.get("result")).floatValue();
		return naverServ.saveResult(result);
	}

	@GetMapping("/test")
	public String testFlaskService(@RequestParam(value = "date") LocalDate date) {
		LocalDateTime dateTime = date.atStartOfDay();
		return naverServ.getValuesAndSendToFlask(dateTime);
	}
}
