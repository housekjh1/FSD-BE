package com.recycle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recycle.domain.Center;
import com.recycle.persistence.CenterRepository;

@Service
public class CenterService {

	@Autowired
	private CenterRepository centerRepo;

	public List<Center> getAll() {
		return centerRepo.findAll();
	}

	public List<Center> getFromKeyword(String keyword) {
		return centerRepo.findCenterByAddressContaining(keyword);
	}

}
