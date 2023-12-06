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
		return comRepo.findByCampsiteName(campsiteName);
	}
}