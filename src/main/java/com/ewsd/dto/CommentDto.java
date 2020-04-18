package com.ewsd.dto;

import java.time.LocalDateTime;

import com.ewsd.model.Idea;
import com.ewsd.model.User;

public class CommentDto {
	
	private Long id;
	
	private Idea ideaId;
	
	private User userId;
	
	private String commentBody;
	
	private LocalDateTime entryDate;
	
	private LocalDateTime updateDate;
	
	private Boolean isDelete;

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

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
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

}
