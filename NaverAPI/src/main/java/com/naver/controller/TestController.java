package com.naver.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naver.domain.LogTable;
import com.naver.service.NaverService;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private NaverService naverServ;

	@GetMapping("/predict")
	public String testFlaskService(@RequestParam String pool, @RequestParam LocalDateTime date) {
		return naverServ.getValuesAndSendToFlask(pool, date);
	}

	@GetMapping("/log")
	public List<LogTable> getLog() {
		return naverServ.getLog();
	}

	@PostMapping("/log")
	public String setLog(LogTable log) {
		return naverServ.setLog(log);
	}
}
