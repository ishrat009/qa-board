package com.ewsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewsd.model.Reaction;
import com.ewsd.repositories.ReactionRepository;

@Service
public class ReactionService {

	@Autowired
	private ReactionRepository reactionRepository;
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
	
	/*
	 * public Reaction findOne(Long id) { return reactionRepository.findOne(id); }
	 */
	
	public void save(Reaction reaction) {
		reactionRepository.save(reaction);
	}
	
	/*
	 * public boolean exists(Long userId, Long ideaId) { for(Reaction reaction :
	 * ideaService.getById(ideaId).getReactions()) {
	 * if(reaction.getUserId().getId().equals(userId)) { return true; } } return
	 * false; }
	 * 
	 * public Reaction fetch(Long ideaId, String username) { // TODO Auto-generated
	 * method stub return
	 * reactionRepository.findByIdeaAndReactedUser(ideaService.getById(ideaId),
	 * userService.getUserByName(username)); }
	 */
}
