package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolE;

public interface ERepository extends JpaRepository<PoolE, Long> {

	@Query("SELECT e FROM PoolE e WHERE e.dateTime < :date ORDER BY e.dateTime DESC")
	List<PoolE> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT e FROM PoolE e WHERE e.dateTime >= :date ORDER BY e.dateTime")
	List<PoolE> findFromDate(LocalDateTime date, Pageable pageable);
}
