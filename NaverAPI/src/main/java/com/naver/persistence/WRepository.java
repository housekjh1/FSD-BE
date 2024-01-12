package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolW;

public interface WRepository extends JpaRepository<PoolW, Long> {

	@Query("SELECT w FROM PoolW w WHERE w.dateTime < :date ORDER BY w.dateTime DESC")
	List<PoolW> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT w FROM PoolW w WHERE w.dateTime >= :date ORDER BY w.dateTime")
	List<PoolW> findFromDate(LocalDateTime date, Pageable pageable);
}
