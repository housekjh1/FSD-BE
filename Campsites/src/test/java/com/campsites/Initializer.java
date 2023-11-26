package com.campsites;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.campsites.domain.Member;
import com.campsites.domain.Role;
import com.campsites.persistence.MemberRepository;

@SpringBootTest
public class Initializer {
	
	@Autowired
	MemberRepository memRepo;
	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Test
	public void doWork() {
		memRepo.save(Member.builder().username("admin").password(encoder.encode("abcd")).role(Role.ROLE_ADMIN).build());
		memRepo.save(Member.builder().username("member").password(encoder.encode("abcd")).role(Role.ROLE_MEMBER).build());
	}
}
