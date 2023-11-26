package com.campsites.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campsites.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
