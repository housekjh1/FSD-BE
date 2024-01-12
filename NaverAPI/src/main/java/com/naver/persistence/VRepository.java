package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolV;

public interface VRepository extends JpaRepository<PoolV, Long> {

	@Query("SELECT v FROM PoolV v WHERE v.dateTime < :date ORDER BY v.dateTime DESC")
	List<PoolV> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT v FROM PoolV v WHERE v.dateTime >= :date ORDER BY v.dateTime")
	List<PoolV> findFromDate(LocalDateTime date, Pageable pageable);
}
