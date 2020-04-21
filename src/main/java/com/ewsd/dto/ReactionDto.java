package com.ewsd.dto;

import com.ewsd.model.Idea;
import com.ewsd.model.User;

public class ReactionDto {
	
	private Long id;
	
	private Idea ideaId;
	
	private User userId;
	
	private Integer reactionType;

	public Integer getReactionType() {
		return reactionType;
	}

	public void setReactionType(Integer reactionType) {
		this.reactionType = reactionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Idea getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Idea ideaId) {
		this.ideaId = ideaId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

}
