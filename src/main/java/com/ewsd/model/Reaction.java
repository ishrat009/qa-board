package com.ewsd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_reaction")
public class Reaction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idea_id")
	private Idea ideaId;
	
	@Column(name="reaction_type", nullable = false, updatable = true)
	private Integer reactionType;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;

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

	public Integer getReactionType() {
		return reactionType;
	}

	public void setReactionType(Integer reactionType) {
		this.reactionType = reactionType;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Reaction(Long id, Idea ideaId, Integer reactionType, User userId) {
		super();
		this.id = id;
		this.ideaId = ideaId;
		this.reactionType = reactionType;
		this.userId = userId;
	}

	public Reaction() {
		super();
	}

	@Override
	public String toString() {
		return "Reaction [id=" + id + ", ideaId=" + ideaId + ", reactionType=" + reactionType + ", userId=" + userId
				+ "]";
	}
	
	
}
