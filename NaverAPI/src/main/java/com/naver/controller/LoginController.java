package com.naver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/loginSuccess")
	public String loginSuccess() {
		return "Login Successful!";
	}

	@GetMapping("/loginFailure")
	public String loginFailure() {
		return "Login Failed!";
	}
}
