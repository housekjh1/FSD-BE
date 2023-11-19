package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {

	@Autowired
	private MemberService memService;

	@GetMapping("/login")
	public void loginView() {
	}

	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member tmp = memService.getMember(member);
		if (tmp != null && tmp.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", tmp);
			return "redirect:getBoardList";
		} else {
			return "redirect:login";
		}
	}
}
