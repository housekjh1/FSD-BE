package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public List<Board> getBoards() {
		return boardService.getBoards();
	}
	
	@GetMapping("/board/{seq}")
	public Board getBoard(@PathVariable Long seq) {
		return boardService.getBoard(seq);
	}
	
	@PostMapping("/board")
	public Board addBoard(Board board) {
		return boardService.addBoard(board);
	}
	
	@PutMapping("/board")
	public Board updateBoard(Board board) {
		return boardService.updateBoard(board);
	}
	
	@DeleteMapping("/board/{seq}")
	public Board removeBoard(@PathVariable Long seq) {
		return boardService.removeBoard(seq);
	}
}
