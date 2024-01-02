package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.Naver;

public interface NaverRepository extends JpaRepository<Naver, Long> {

	@Query("SELECT n FROM Naver n WHERE n.aDateTime < :date ORDER BY n.aDateTime DESC")
	List<Naver> findTop90ByADateTimeBefore(LocalDateTime date, Pageable pageable);
}
