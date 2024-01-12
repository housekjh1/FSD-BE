package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolM;

public interface MRepository extends JpaRepository<PoolM, Long> {

	@Query("SELECT m FROM PoolM m WHERE m.dateTime < :date ORDER BY m.dateTime DESC")
	List<PoolM> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT m FROM PoolM m WHERE m.dateTime >= :date ORDER BY m.dateTime")
	List<PoolM> findFromDate(LocalDateTime date, Pageable pageable);
}
