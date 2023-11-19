package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository brdRepo;
	
	public List<Board> getBoardList() {
		return brdRepo.findAll();
	}
	
	public void insertBoard(Board board) {
		brdRepo.save(board);
	}
	
	public Board getBoard(Board board) {
		Optional<Board> opt = brdRepo.findById(board.getSeq());
		if (!opt.isPresent()) return null;
		Board tmp = opt.get();
		Long n = tmp.getCnt();
		tmp.setCnt(++n);
		brdRepo.save(tmp);
		return tmp;
	}
	
	public void updateBoard(Board board) {
		Board tmp = brdRepo.findById(board.getSeq()).get();
		if (board.getTitle() != null) tmp.setTitle(board.getTitle());
		if (board.getContent() != null) tmp.setContent(board.getContent());
		brdRepo.save(tmp);
	}
	
	public void deleteBoard(Board board) {
		brdRepo.deleteById(board.getSeq());
	}
}
