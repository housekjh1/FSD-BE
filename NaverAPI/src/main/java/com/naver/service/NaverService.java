package com.naver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.domain.Naver;
import com.naver.persistence.NaverRepository;

@Service
public class NaverService {
	
	@Autowired
	private NaverRepository naverRepo;

	public String saveResult(Float result) {
		naverRepo.save(Naver.builder().result(result).build());
		return "ok";
	}
}
