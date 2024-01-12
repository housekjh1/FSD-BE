package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolJ;

public interface JRepository extends JpaRepository<PoolJ, Long> {

	@Query("SELECT j FROM PoolJ j WHERE j.dateTime < :date ORDER BY j.dateTime DESC")
	List<PoolJ> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT j FROM PoolJ j WHERE j.dateTime >= :date ORDER BY j.dateTime")
	List<PoolJ> findFromDate(LocalDateTime date, Pageable pageable);
}
