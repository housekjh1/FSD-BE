package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolH;

public interface HRepository extends JpaRepository<PoolH, Long> {

	@Query("SELECT h FROM PoolH h WHERE h.dateTime < :date ORDER BY h.dateTime DESC")
	List<PoolH> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT h FROM PoolH h WHERE h.dateTime >= :date ORDER BY h.dateTime")
	List<PoolH> findFromDate(LocalDateTime date, Pageable pageable);
}
