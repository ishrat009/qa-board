package com.ewsd.request_models;

import java.io.Serializable;

import com.ewsd.model.Idea;

public class ReactionRm implements Serializable {

	private long id;

	private Idea idea;

	private User user;
	
	private Integer reactionType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getReactionType() {
		return reactionType;
	}

	public void setReactionType(Integer reactionType) {
		this.reactionType = reactionType;
	}
	
	
}
