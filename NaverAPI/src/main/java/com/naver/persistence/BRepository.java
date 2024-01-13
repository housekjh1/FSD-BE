package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolB;

public interface BRepository extends JpaRepository<PoolB, Long> {

	@Query("SELECT b FROM PoolB b WHERE b.dateTime < :date ORDER BY b.dateTime DESC")
	List<PoolB> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT b FROM PoolB b WHERE b.dateTime >= :date ORDER BY b.dateTime")
	List<PoolB> findFromDate(LocalDateTime date, Pageable pageable);
}
