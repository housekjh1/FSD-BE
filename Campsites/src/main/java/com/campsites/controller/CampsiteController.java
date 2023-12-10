package com.campsites.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.campsites.domain.Campsite;
import com.campsites.service.CampsiteService;

@RestController
public class CampsiteController {

	@Autowired
	private CampsiteService campService;

//	@GetMapping("/api/campsites")
//	public List<Campsite> getAll() {
//		return campService.getAll();
//	}

	@GetMapping("/api/search/{keyword}")
	public List<Campsite> getFromKeyword(@PathVariable String keyword) {
		return campService.getFromKeyword(keyword);
	}
}
