package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.BoardDomain;

public class BoardService {
	private List<BoardDomain> list;
	
	public BoardService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			list.add(BoardDomain.builder()
								.seq(i)
								.title("title"+i)
								.writer("writer"+i)
								.content("content"+i)
								.createDate(new Date())
								.cnt(0)
								.build());
		}
	}
	public List<BoardDomain> getBoards() {
		
		return list;
	}
	public BoardDomain getBoard(Integer seq) {
		for (BoardDomain b : list) {
			if (b.getSeq() == seq) {
				return b;
			}
		}

		return null;
	}
	public BoardDomain addBoard(BoardDomain boardDomain) {
		int idx = -1;
		for (BoardDomain b : list) {
			if (idx < b.getSeq()) idx = b.getSeq();
		}
		if (list.isEmpty()) idx = 1;
		else idx++;
		if (boardDomain.getTitle() == null || boardDomain.getWriter() == null || boardDomain.getContent() == null) return null;
		
		BoardDomain tmp = BoardDomain.builder()
									.seq(idx)
									.title(boardDomain.getTitle())
									.writer(boardDomain.getWriter())
									.content(boardDomain.getContent())
									.createDate(new Date())
									.cnt(0)
									.build();
		list.add(tmp);
		return tmp;
	}
	public BoardDomain updateBoard(BoardDomain boardDomain) {
		for (BoardDomain b : list) {
			if (b.getSeq() == boardDomain.getSeq()) {
				if (boardDomain.getTitle() != null) b.setTitle(boardDomain.getTitle());
				if (boardDomain.getWriter() != null) b.setWriter(boardDomain.getWriter());
				if (boardDomain.getContent() != null) b.setContent(boardDomain.getContent());
				return b;
			}
		}
		
		return null;
	}
	public BoardDomain deleteBoard(Integer seq) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSeq() == seq) {
				BoardDomain tmp = list.get(i);
				list.remove(i);
				return tmp;
			}
		}
		
		return null;
	}

}
