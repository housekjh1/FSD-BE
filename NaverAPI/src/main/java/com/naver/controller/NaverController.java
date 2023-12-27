package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverController {

	@GetMapping("/oauth2/naver")
	public String login() {
		return "redirect:/oauth2/authorization/naver";
	}
}
