package com.naver.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.naver.domain.Naver;
import com.naver.persistence.NaverRepository;

@Service
public class NaverService {

	@Autowired
	private NaverRepository naverRepo;

	@Autowired
	private RestTemplate restTemplate;

	public String saveResult(Float result) {
		naverRepo.save(Naver.builder().result(result).build());
		return "ok";
	}

	public String getValuesAndSendToFlask(LocalDateTime date) {
		// 상위 90개 결과를 가져오기 위한 Pageable 객체 생성
		Pageable topNinety = PageRequest.of(0, 90, Sort.by("aDateTime").descending());

		// DB에서 날짜 이전의 최신 90개 값을 가져옴
		List<Naver> navers = naverRepo.findTop90ByADateTimeBefore(date, topNinety);

		// 결과를 역정렬하여 오름차순으로 변경
		Collections.reverse(navers);

		// aValues 필드 값을 추출하여 Double 리스트로 변환
		List<Double> doubleValues = navers.stream().map(naver -> Double.parseDouble(naver.getAValues()))
				.collect(Collectors.toList());

		// Flask 서버의 URL
		String flaskUrl = "http://localhost:5000/test";

		// Flask 서버로 값 전송 후 결과 반환
		return restTemplate.postForObject(flaskUrl, doubleValues, String.class);
	}
}
