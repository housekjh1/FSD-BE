package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolC;

public interface CRepository extends JpaRepository<PoolC, Long> {

	@Query("SELECT c FROM PoolC c WHERE c.dateTime < :date ORDER BY c.dateTime DESC")
	List<PoolC> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT c FROM PoolC c WHERE c.dateTime >= :date ORDER BY c.dateTime")
	List<PoolC> findFromDate(LocalDateTime date, Pageable pageable);
}
