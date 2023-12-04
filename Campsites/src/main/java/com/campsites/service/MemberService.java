package com.campsites.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campsites.domain.Member;
import com.campsites.domain.Role;
import com.campsites.persistence.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memRepo;

	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	public String join(String username, String password, String passwordConfirm) {
		Optional<Member> opt = memRepo.findById(username);
		if (!opt.isPresent()) {
			if (password.equals(passwordConfirm)) {
				memRepo.save(Member.builder().username(username).password(encoder.encode(password))
						.role(Role.ROLE_MEMBER).enable(true).build());
				return "ok";
			} else {
				return "passwordMatchFailure";
			}
		} else if (opt.get().getUsername().equals(username)) {
			return "usernameDuplication";
		}
		return "error";
	}
}
