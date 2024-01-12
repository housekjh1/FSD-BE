package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolS;

public interface SRepository extends JpaRepository<PoolS, Long> {

	@Query("SELECT s FROM PoolS s WHERE s.dateTime < :date ORDER BY s.dateTime DESC")
	List<PoolS> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT s FROM PoolS s WHERE s.dateTime >= :date ORDER BY s.dateTime")
	List<PoolS> findFromDate(LocalDateTime date, Pageable pageable);
}
