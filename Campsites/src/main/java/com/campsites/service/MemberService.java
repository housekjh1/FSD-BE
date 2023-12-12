package com.campsites.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.campsites.domain.Member;
import com.campsites.domain.Response;
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
						.role(Role.ROLE_MEMBER).build());
				return "ok";
			} else {
				return "passwordMatchFailure";
			}
		} else if (opt.get().getUsername().equals(username)) {
			return "usernameDuplication";
		}
		return "error";
	}

	public Response member(String token) {
		// Map 객체로 보내는 방법도 검토하기
		if (token == null || !token.startsWith("Bearer ")) {
			return Response.builder().key("error").value("invalidToken").build();
		}
		String jwtToken = token.replace("Bearer ", "");
		String username = null;
		try {
			username = JWT.require(Algorithm.HMAC256("com.campsites.jwt")).build().verify(jwtToken).getClaim("username")
					.asString();
		} catch (Exception e) {
			return Response.builder().key("error").value("decodingError").build();
		}
		Optional<Member> opt = memRepo.findById(username);
		if (!opt.isPresent()) {
			return Response.builder().key("error").value("invalidMember").build();
		}
		Member tmp = opt.get();
		return Response.builder().key("success").value(tmp.getUsername()).build();
	}

	public Response change(String username, String password, String passwordConfirm) {
		Optional<Member> opt = memRepo.findById(username);
		if (!opt.isPresent()) {
			return Response.builder().key("error").value("invalidMember").build();
		}
		if (!password.equals(passwordConfirm)) {
			return Response.builder().key("error").value("passwordMatchFailure").build();
		}
		Member tmp = opt.get();
		tmp.setPassword(encoder.encode(password));
		memRepo.save(tmp);
		return Response.builder().key("success").value("ok").build();
	}

	public Response quit(String username) {
		// Map 객체로 보내는 방법도 검토하기
		Optional<Member> opt = memRepo.findById(username);
		if (!opt.isPresent()) {
			return Response.builder().key("error").value("invalidMember").build();
		}
		Member tmp = opt.get();
		memRepo.deleteById(tmp.getUsername());
		return Response.builder().key("success").value("ok").build();
	}
}
