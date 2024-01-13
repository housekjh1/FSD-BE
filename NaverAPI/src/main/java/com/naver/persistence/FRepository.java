package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolF;

public interface FRepository extends JpaRepository<PoolF, Long> {

	@Query("SELECT f FROM PoolF f WHERE f.dateTime < :date ORDER BY f.dateTime DESC")
	List<PoolF> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT f FROM PoolF f WHERE f.dateTime >= :date ORDER BY f.dateTime")
	List<PoolF> findFromDate(LocalDateTime date, Pageable pageable);
}
