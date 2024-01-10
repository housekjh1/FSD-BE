package com.naver.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naver.domain.Naver;

public interface NaverRepository extends JpaRepository<Naver, Long> {

}
