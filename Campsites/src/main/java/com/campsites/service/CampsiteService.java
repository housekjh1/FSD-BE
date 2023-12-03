package com.campsites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campsites.domain.Campsite;
import com.campsites.persistence.CampsiteRepository;

@Service
public class CampsiteService {

	@Autowired
	private CampsiteRepository campRepo;

	public List<Campsite> getAll() {
		return campRepo.findAll();
	}

	public List<Campsite> getFromKeyword(String keyword) {
		return campRepo.findCampsiteByAddressContaining(keyword);
	}
	
	public String join(String username, String password, String passwordConfirm) {
		
		return null;
	}
}
