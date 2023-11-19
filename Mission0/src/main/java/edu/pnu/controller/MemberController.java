package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDomain;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	private MemberService memberService = new MemberService();
	
	@GetMapping("/member")
	public List<MemberDomain> getMembers() {
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberDomain getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberDomain addMember(MemberDomain memberDomain) {
		return memberService.addMember(memberDomain);
	}
	
	@PutMapping("/member")
	public MemberDomain updateMember(MemberDomain memberDomain) {
		return memberService.updateMember(memberDomain);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberDomain deleteMember(@PathVariable Integer id) {
		return memberService.deleteMember(id);
	}
}
