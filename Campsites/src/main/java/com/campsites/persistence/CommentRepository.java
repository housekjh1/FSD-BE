package com.campsites.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campsites.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByCampsiteName(String campsiteName);
}
