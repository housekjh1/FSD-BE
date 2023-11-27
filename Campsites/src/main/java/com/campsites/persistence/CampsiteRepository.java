package com.campsites.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campsites.domain.Campsite;

public interface CampsiteRepository extends JpaRepository<Campsite, String> {

	List<Campsite> findCampsiteByAddressContaining(String keyword);
}
