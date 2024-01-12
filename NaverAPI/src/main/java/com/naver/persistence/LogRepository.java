package com.naver.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naver.domain.LogTable;

public interface LogRepository extends JpaRepository<LogTable, Long> {

}
