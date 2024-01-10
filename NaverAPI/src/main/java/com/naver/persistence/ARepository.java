package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.PoolA;
import com.naver.domain.DTO.PoolADTO;

public interface ARepository extends JpaRepository<PoolA, Long> {
	@Query("SELECT a.dateTime, a.data1, a.data2, a.data3, a.data4 FROM PoolA a WHERE a.dateTime < :date ORDER BY a.dateTime DESC")
	List<PoolADTO> findA(LocalDateTime date, Pageable pageable);
}
