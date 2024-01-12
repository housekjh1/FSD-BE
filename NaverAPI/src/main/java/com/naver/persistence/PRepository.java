package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolP;

public interface PRepository extends JpaRepository<PoolP, Long> {

	@Query("SELECT p FROM PoolP p WHERE p.dateTime < :date ORDER BY p.dateTime DESC")
	List<PoolP> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT p FROM PoolP p WHERE p.dateTime >= :date ORDER BY p.dateTime")
	List<PoolP> findFromDate(LocalDateTime date, Pageable pageable);
}
