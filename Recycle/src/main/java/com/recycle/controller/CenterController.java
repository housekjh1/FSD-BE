package com.recycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.recycle.domain.Center;
import com.recycle.service.CenterService;

@RestController
public class CenterController {

	@Autowired
	private CenterService centerService;

	@GetMapping("/api/test")
	public List<Center> test() {
		return centerService.getAll();
	}

	@GetMapping("/api/test/{keyword}")
	public List<Center> test2(@PathVariable String keyword) {
		return centerService.getFromKeyword(keyword);
	}
}
