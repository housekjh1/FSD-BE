package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolI;

public interface IRepository extends JpaRepository<PoolI, Long> {

	@Query("SELECT i FROM PoolI i WHERE i.dateTime < :date ORDER BY i.dateTime DESC")
	List<PoolI> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT i FROM PoolI i WHERE i.dateTime >= :date ORDER BY i.dateTime")
	List<PoolI> findFromDate(LocalDateTime date, Pageable pageable);
}
