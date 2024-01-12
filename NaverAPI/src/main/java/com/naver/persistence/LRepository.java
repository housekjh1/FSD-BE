package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolL;

public interface LRepository extends JpaRepository<PoolL, Long> {

	@Query("SELECT l FROM PoolL l WHERE l.dateTime < :date ORDER BY l.dateTime DESC")
	List<PoolL> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT l FROM PoolL l WHERE l.dateTime >= :date ORDER BY l.dateTime")
	List<PoolL> findFromDate(LocalDateTime date, Pageable pageable);
}
