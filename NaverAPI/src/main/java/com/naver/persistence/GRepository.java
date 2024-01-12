package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolG;

public interface GRepository extends JpaRepository<PoolG, Long> {

	@Query("SELECT g FROM PoolG g WHERE g.dateTime < :date ORDER BY g.dateTime DESC")
	List<PoolG> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT g FROM PoolG g WHERE g.dateTime >= :date ORDER BY g.dateTime")
	List<PoolG> findFromDate(LocalDateTime date, Pageable pageable);
}
