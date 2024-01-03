package com.naver.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.naver.persistence.NaverRepository;

@Service
public class NaverService {

	@Autowired
	private NaverRepository naverRepo;

	@Autowired
	private RestTemplate restTemplate;

	public String getValuesAndSendToFlask(String pool, LocalDateTime date) {
		// 상위 90개 결과를 가져오기 위한 Pageable 객체 생성
		Pageable topNinety = PageRequest.of(0, 90, Sort.by("dateTime").descending());
		List<Double> values = null;

		if (pool.equals("A")) {
			values = naverRepo.findA(date, topNinety);
		} else if (pool.equals("B")) {
			values = naverRepo.findB(date, topNinety);
		} else if (pool.equals("C")) {
			values = naverRepo.findC(date, topNinety);
		} else if (pool.equals("D")) {
			values = naverRepo.findD(date, topNinety);
		} else if (pool.equals("E")) {
			values = naverRepo.findE(date, topNinety);
		} else if (pool.equals("F")) {
			values = naverRepo.findF(date, topNinety);
		} else if (pool.equals("G")) {
			values = naverRepo.findG(date, topNinety);
		} else if (pool.equals("H")) {
			values = naverRepo.findH(date, topNinety);
		} else if (pool.equals("I")) {
			values = naverRepo.findI(date, topNinety);
		} else if (pool.equals("J")) {
			values = naverRepo.findJ(date, topNinety);
		} else if (pool.equals("L")) {
			values = naverRepo.findL(date, topNinety);
		} else if (pool.equals("M")) {
			values = naverRepo.findM(date, topNinety);
		} else if (pool.equals("N")) {
			values = naverRepo.findN(date, topNinety);
		} else if (pool.equals("O")) {
			values = naverRepo.findO(date, topNinety);
		} else if (pool.equals("P")) {
			values = naverRepo.findP(date, topNinety);
		} else if (pool.equals("Q")) {
			values = naverRepo.findQ(date, topNinety);
		} else if (pool.equals("S")) {
			values = naverRepo.findS(date, topNinety);
		} else if (pool.equals("T")) {
			values = naverRepo.findT(date, topNinety);
		} else if (pool.equals("U")) {
			values = naverRepo.findU(date, topNinety);
		} else if (pool.equals("V")) {
			values = naverRepo.findV(date, topNinety);
		} else if (pool.equals("W")) {
			values = naverRepo.findW(date, topNinety);
		} else {
			return "error";
		}

		// 결과를 역정렬하여 오름차순으로 변경
		Collections.reverse(values);

		// Flask 서버의 URL
		String flaskUrl = "http://localhost:5000/predict";

		// 전송할 데이터 맵 생성
		Map<String, Object> requestData = new HashMap<>();
		requestData.put("pool", pool);
		requestData.put("values", values);

		// Flask 서버로 데이터 전송 후 결과 반환
		return restTemplate.postForObject(flaskUrl, requestData, String.class);
	}
}
