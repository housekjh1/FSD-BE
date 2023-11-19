package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberDomain;

public class MemberService {
	private List<MemberDomain> list;
	
	public MemberService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			list.add(MemberDomain.builder().id(i).pass("1234").name("name"+i).regidate(new Date()).build());
		}
	}

	public List<MemberDomain> getMembers() {
		return list;
	}

	public MemberDomain getMember(Integer id) {
		for (MemberDomain m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	public MemberDomain addMember(MemberDomain memberDomain) {
		int idx = -1;
		
		for (MemberDomain m : list) {
			if (idx < m.getId()) idx = m.getId();
		}
		
		if (list.isEmpty()) idx = 1;
		else idx++;
		if (memberDomain.getPass() == null || memberDomain.getName() == null) return null;
		
		MemberDomain tmp = MemberDomain.builder()
				.id(idx)
				.pass(memberDomain.getPass())
				.name(memberDomain.getName())
				.regidate(new Date())
				.build();
		
		list.add(tmp);
		
		return tmp;
	}

	public MemberDomain updateMember(MemberDomain memberDomain) {
		for (MemberDomain m : list) {
			if (m.getId() == memberDomain.getId()) {
				if (memberDomain.getPass() != null)
					m.setPass(memberDomain.getPass());
				if (memberDomain.getName() != null)
					m.setName(memberDomain.getName());
				return m;
			}
		}
		return null;
	}

	public MemberDomain deleteMember(Integer id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				MemberDomain tmp = list.get(i);
				list.remove(i);
				return tmp;
			}
		}
		return null;
	}
	
}
