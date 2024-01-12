package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolU;

public interface URepository extends JpaRepository<PoolU, Long> {

	@Query("SELECT u FROM PoolU u WHERE u.dateTime < :date ORDER BY u.dateTime DESC")
	List<PoolU> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT u FROM PoolU u WHERE u.dateTime >= :date ORDER BY u.dateTime")
	List<PoolU> findFromDate(LocalDateTime date, Pageable pageable);
}
