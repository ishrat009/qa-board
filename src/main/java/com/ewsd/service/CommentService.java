package com.ewsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewsd.model.Comment;
import com.ewsd.model.Idea;
import com.ewsd.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
	
	/*
	 * public Comment findOne(Long id) { return commentRepository.findOne(id); }
	 */
	
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}
	
	/*
	 * public boolean exists(Long userId, Long ideaId) { for(Comment comment :
	 * ideaService.getById(ideaId).getComments()) {
	 * if(comment.getUserId().getId().equals(userId)) { return true; } } return
	 * false; }
	 * 
	 * public List<Comment> findAllByIdea(Idea idea){ return
	 * commentRepository.findAllByIdea(idea); }
	 * 
	 * public Comment fetch(Long ideaId, String username) { // TODO Auto-generated
	 * method stub return
	 * commentRepository.findByIdeaAndCommentedUser(ideaService.getById(ideaId),
	 * userService.getUserByName(username)); }
	 */

}
