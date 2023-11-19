package edu.pnu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memRepo;
	
	public Member getMember(Member member) {
		Optional<Member> opt = memRepo.findById(member.getId());
		if (!opt.isPresent()) return null;
		Member tmp = opt.get();
		return tmp;
	}
}
