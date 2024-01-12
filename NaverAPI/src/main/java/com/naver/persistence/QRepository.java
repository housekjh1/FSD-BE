package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolQ;

public interface QRepository extends JpaRepository<PoolQ, Long> {

	@Query("SELECT q FROM PoolQ q WHERE q.dateTime < :date ORDER BY q.dateTime DESC")
	List<PoolQ> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT q FROM PoolQ q WHERE q.dateTime >= :date ORDER BY q.dateTime")
	List<PoolQ> findFromDate(LocalDateTime date, Pageable pageable);
}
