package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolT;

public interface TRepository extends JpaRepository<PoolT, Long> {

	@Query("SELECT t FROM PoolT t WHERE t.dateTime < :date ORDER BY t.dateTime DESC")
	List<PoolT> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT t FROM PoolT t WHERE t.dateTime >= :date ORDER BY t.dateTime")
	List<PoolT> findFromDate(LocalDateTime date, Pageable pageable);
}
