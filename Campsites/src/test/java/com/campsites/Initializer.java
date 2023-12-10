package com.campsites;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.campsites.domain.Member;
import com.campsites.domain.Role;
import com.campsites.persistence.CampsiteRepository;
import com.campsites.persistence.CommentRepository;
import com.campsites.persistence.MemberRepository;

@SpringBootTest
public class Initializer {

	@Autowired
	MemberRepository memRepo;

	@Autowired
	CampsiteRepository camRepo;

	@Autowired
	CommentRepository comRepo;

	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Test
	public void doWork() {
		Member admin = Member.builder().username("admin").password(encoder.encode("abcd")).role(Role.ROLE_ADMIN)
				.build();
		Member member = Member.builder().username("member").password(encoder.encode("abcd")).role(Role.ROLE_MEMBER)
				.build();
		memRepo.save(admin);
		memRepo.save(member);
	}
}
