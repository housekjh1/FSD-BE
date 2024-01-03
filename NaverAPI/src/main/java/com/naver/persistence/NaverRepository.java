package com.naver.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naver.domain.Naver;

public interface NaverRepository extends JpaRepository<Naver, Long> {

	@Query("SELECT n.aValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findA(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.bValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findB(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.cValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findC(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.dValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findD(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.eValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findE(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.fValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findF(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.gValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findG(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.hValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findH(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.iValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findI(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.jValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findJ(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.lValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findL(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.mValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findM(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.nValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findN(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.oValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findO(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.pValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findP(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.qValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findQ(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.sValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findS(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.tValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findT(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.uValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findU(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.vValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findV(LocalDateTime date, Pageable pageable);

	@Query("SELECT n.wValues FROM Naver n WHERE n.dateTime < :date ORDER BY n.dateTime DESC")
	List<Double> findW(LocalDateTime date, Pageable pageable);
}
