package edu.pnu;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class BoardTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	@DisplayName("10개 입력")
	public void BoardInsert() {
		Random rd = new Random();
		for (int i = 1; i <= 10; i++) {
			boardRepo.save(Board.builder().title("title"+i).writer("writer"+i).content("content"+i).build());
		}
	}
}
