package com.naver.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import com.naver.domain.LogTable;
import com.naver.domain.PoolA;
import com.naver.persistence.ARepository;
import com.naver.persistence.LogRepository;

@Service
public class NaverService {

	@Autowired
	private LogRepository logRepo;

	@Autowired
	private ARepository aRepo;

	@Autowired
	private RestTemplate restTemplate;

	public String getValuesAndSendToFlask(String pool, LocalDateTime date) {

		Pageable previousDataPageable = PageRequest.of(0, 144, Sort.by("dateTime").descending());
		Pageable nextDataPageable = PageRequest.of(0, 144, Sort.by("dateTime"));

		List<PoolA> values = new ArrayList<>();

		Map<String, Object> requestData = new HashMap<>();

		if (pool.equals("A")) {
			List<PoolA> beforeData = aRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolA> fromData = aRepo.findFromDate(date, nextDataPageable);

			values.addAll(beforeData);
			values.addAll(fromData);

			requestData.put("values", values);
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

	public List<LogTable> getLog() {
		return logRepo.findAll();
	}

	public String setLog(LogTable log) {
		try {
			logRepo.save(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
}
