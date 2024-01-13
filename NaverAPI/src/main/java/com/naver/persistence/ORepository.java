package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolO;

public interface ORepository extends JpaRepository<PoolO, Long> {

	@Query("SELECT o FROM PoolO o WHERE o.dateTime < :date ORDER BY o.dateTime DESC")
	List<PoolO> findBeforeDate(LocalDateTime date, Pageable pageable);

	@Query("SELECT o FROM PoolO o WHERE o.dateTime >= :date ORDER BY o.dateTime")
	List<PoolO> findFromDate(LocalDateTime date, Pageable pageable);
}
