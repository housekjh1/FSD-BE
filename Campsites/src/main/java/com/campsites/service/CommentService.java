package com.campsites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campsites.domain.Comment;
import com.campsites.persistence.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository comRepo;

	public List<Comment> getAll() {
		return comRepo.findAll();
	}

	public List<Comment> getComment(String campsiteName) {
		return comRepo.findAllByCampsiteNameOrderBySeqDesc(campsiteName);
	}

	public String commentInput(String campsiteName, String writer, String content) {
		comRepo.save(Comment.builder().campsiteName(campsiteName).writer(writer).content(content).build());
		return "ok";
	}

	public String commentUpdate(String seq, String content) {
		Comment tmp = comRepo.findById(Long.parseLong(seq)).get();
		tmp.setContent(content);
		tmp.setEdited(true);
		comRepo.save(tmp);
		return "ok";
	}

	public String commentRemove(String seq) {
		comRepo.deleteById(Long.parseLong(seq));
		return "ok";
	}
}
