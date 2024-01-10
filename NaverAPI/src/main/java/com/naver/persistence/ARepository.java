package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolA;

public interface ARepository extends JpaRepository<PoolA, Long> {

	@Query("SELECT a FROM PoolA a WHERE a.dateTime < :date ORDER BY a.dateTime DESC")
	List<PoolA> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT a FROM PoolA a WHERE a.dateTime >= :date ORDER BY a.dateTime")
	List<PoolA> findFromDate(LocalDateTime date, Pageable pageable);
}
