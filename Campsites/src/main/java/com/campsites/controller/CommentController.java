package com.campsites.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campsites.domain.Comment;
import com.campsites.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService comService;

	@GetMapping("/api/comments")
	public List<Comment> getAll() {
		return comService.getAll();
	}

	@PostMapping("/api/comment")
	public List<Comment> getComment(String campsiteName) {
		return comService.getComment(campsiteName);
	}
}
