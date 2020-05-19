package com.ewsd.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_comment")
public class Comment implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", length=20, nullable=false)
	private Long id;
	
	@Column(name="comment_body", nullable=false)
	private String commentBody;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "idea_id", nullable = false)
	private Idea ideaId;
	
	@Column(name="anonymous")
	private Boolean isAnonymous;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;
	
	@Column(name = "e_date")
	private LocalDateTime entryDate;
	
	@Column(name = "u_date")
	private LocalDateTime updateDate;
	
	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Idea getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Idea ideaId) {
		this.ideaId = ideaId;
	}

	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Comment(Long id, String commentBody, Idea ideaId, Boolean isAnonymous, User userId, LocalDateTime entryDate,
			LocalDateTime updateDate, Boolean isDelete) {
		super();
		this.id = id;
		this.commentBody = commentBody;
		this.ideaId = ideaId;
		this.isAnonymous = isAnonymous;
		this.userId = userId;
		this.entryDate = entryDate;
		this.updateDate = updateDate;
		this.isDelete = isDelete;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentBody=" + commentBody + ", ideaId=" + ideaId + ", isAnonymous="
				+ isAnonymous + ", userId=" + userId + ", entryDate=" + entryDate + ", updateDate=" + updateDate
				+ ", isDelete=" + isDelete + "]";
	}


	
}
