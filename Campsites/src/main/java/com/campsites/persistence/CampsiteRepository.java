package com.campsites.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campsites.domain.Campsite;

public interface CampsiteRepository extends JpaRepository<Campsite, String> {

}
