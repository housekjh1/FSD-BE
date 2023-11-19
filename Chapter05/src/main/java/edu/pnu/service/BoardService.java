package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepo;

	public List<Board> getBoards() {
		return (List<Board>) boardRepo.findAll();
	}

	public Board getBoard(Long seq) {
		Board result = boardRepo.findById(seq).get();
		return result;
	}

	public Board addBoard(Board board) {
		Board result = Board.builder().title(board.getTitle()).writer(board.getWriter()).content(board.getContent()).build();
		boardRepo.save(result);
		return result;
	}

	public Board updateBoard(Board board) {
		Board tmp = boardRepo.findById(board.getSeq()).get();
		if (board.getTitle() != null) tmp.setTitle(board.getTitle());
		if (board.getWriter() != null) tmp.setWriter(board.getWriter());
		if (board.getContent() != null) tmp.setContent(board.getContent());
		boardRepo.save(tmp);
		return tmp;
	}

	public Board removeBoard(Long seq) {
		Board result = boardRepo.findById(seq).get();
		boardRepo.deleteById(seq);
		return result;
	}
	
	
}
