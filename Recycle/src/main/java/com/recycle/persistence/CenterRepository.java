package com.recycle.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycle.domain.Center;

public interface CenterRepository extends JpaRepository<Center, Long> {
	
	List<Center> findCenterByAddressContaining(String keyword);
}
