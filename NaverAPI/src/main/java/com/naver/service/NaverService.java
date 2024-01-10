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

import com.naver.domain.DTO.PoolADTO;
import com.naver.persistence.ARepository;

@Service
public class NaverService {

	@Autowired
	private ARepository aRepo;

	@Autowired
	private RestTemplate restTemplate;

	public String getValuesAndSendToFlask(String pool, LocalDateTime date) {

		// 상위 90개 결과를 가져오기 위한 Pageable 객체 생성
		Pageable topNinety = PageRequest.of(0, 90, Sort.by("dateTime").descending());
		List<PoolADTO> valuesA = null;
		Map<String, Object> requestData = new HashMap<>();

		if (pool.equals("A")) {

			valuesA = aRepo.findA(date, topNinety);

			// 결과를 역정렬하여 오름차순으로 변경
			Collections.reverse(valuesA);

			requestData.put("values", valuesA);
		} else {
			return "error";
		}

		// Flask 서버의 URL
		String flaskUrl = "http://localhost:5000/predict";

		// 전송할 데이터 맵 생성
		requestData.put("pool", pool);

		// Flask 서버로 데이터 전송 후 결과 반환
		return restTemplate.postForObject(flaskUrl, requestData, String.class);
	}
}
