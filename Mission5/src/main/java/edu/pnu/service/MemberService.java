package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepo;

	public List<Member> getMembers() {
		return memberRepo.findAll();
	}

	public Member getMember(Integer id) {
		if (!memberRepo.findById(id).isPresent())
			return null;
		return memberRepo.findById(id).get();
	}

	public Member addMember(Member member) {
		if (member.getPass() == null || member.getName() == null)
			return null;
		Member tmp = Member.builder().pass(member.getPass()).name(member.getName()).build();
		memberRepo.save(tmp);
		return tmp;
	}

	public Member updateMember(Member member) {
		if (!memberRepo.findById(member.getId()).isPresent())
			return null;
		Member tmp = memberRepo.findById(member.getId()).get();
		if (member.getPass() != null)
			tmp.setPass(member.getPass());
		if (member.getName() != null)
			tmp.setName(member.getName());
		memberRepo.save(tmp);
		return tmp;
	}

	public Member removeMember(Integer id) {
		if (!memberRepo.findById(id).isPresent()) return null;
		Member tmp = memberRepo.findById(id).get();
		memberRepo.deleteById(id);
		return tmp;
	}
}
