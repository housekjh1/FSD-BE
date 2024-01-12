package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolN;

public interface NRepository extends JpaRepository<PoolN, Long> {

	@Query("SELECT n FROM PoolN n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<PoolN> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT n FROM PoolN n WHERE n.dateTime >= :date ORDER BY n.dateTime")
	List<PoolN> findFromDate(LocalDateTime date, Pageable pageable);
}
