package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardDomain;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	BoardService boardService = new BoardService();
	
	@GetMapping("/board")
	public List<BoardDomain> getBoards() {
		return boardService.getBoards();
	}
	
	@GetMapping("/board/{seq}")
	public BoardDomain getBoard(@PathVariable Integer seq) {
		return boardService.getBoard(seq);
	}
	
	@PostMapping("/board")
	public BoardDomain addBoard(BoardDomain boardDomain) {
		return boardService.addBoard(boardDomain);
	}
	
	@PutMapping("/board")
	public BoardDomain updateBoard(BoardDomain boardDomain) {
		return boardService.updateBoard(boardDomain);
	}
	
	@DeleteMapping("/board/{seq}")
	public BoardDomain deleteBoard(@PathVariable Integer seq) {
		return boardService.deleteBoard(seq);
	}
}
