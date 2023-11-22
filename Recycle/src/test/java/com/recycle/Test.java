package com.recycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.recycle.domain.Member;
import com.recycle.domain.Role;
import com.recycle.persistence.MemberRepository;

@SpringBootTest
public class Test {
	
	@Autowired
	private MemberRepository memRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@org.junit.jupiter.api.Test
	public void test() {
		memRepo.save(Member.builder().username("user").password(encoder.encode("abcd")).role(Role.ROLE_MEMBER).build());
		memRepo.save(Member.builder().username("admin").password(encoder.encode("abcd")).role(Role.ROLE_ADMIN).build());
	}
}
