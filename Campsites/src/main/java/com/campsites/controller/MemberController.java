package com.campsites.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campsites.domain.Response;
import com.campsites.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memService;

	@PostMapping("/join")
	public String join(String username, String password, String passwordConfirm) {
		return memService.join(username, password, passwordConfirm);
	}

	@PostMapping("/member")
	public Response member(String token) {
		return memService.member(token);
	}

	@DeleteMapping("/quit")
	public Response quit(String username) {
		return memService.quit(username);
	}
}
