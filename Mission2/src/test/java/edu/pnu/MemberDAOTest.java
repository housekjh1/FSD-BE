package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
public class MemberDAOTest {
	
//	@DisplayName("Insert Member Test")
//	@Test
//	public void testInsert() {
//		MemberDAO dao = new MemberDAO();
//		dao.addMember(MemberVO.builder().pass("1234").name("테스트").build());
//	}
	
//	@DisplayName("Select Members Test")
//	@Test
//	public void testSelectMembers() {
//		MemberDAO dao = new MemberDAO();
//		List<MemberVO> list = dao.getMembers();
//		for (MemberVO m : list) {
//			System.out.println(m);
//		}
//	}
}
