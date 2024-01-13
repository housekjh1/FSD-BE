package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolD;

public interface DRepository extends JpaRepository<PoolD, Long> {

	@Query("SELECT d FROM PoolD d WHERE d.dateTime < :date ORDER BY d.dateTime DESC")
	List<PoolD> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT d FROM PoolD d WHERE d.dateTime >= :date ORDER BY d.dateTime")
	List<PoolD> findFromDate(LocalDateTime date, Pageable pageable);
}
