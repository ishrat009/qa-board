package com.ewsd.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ewsd.model.Attachment;
import com.ewsd.model.Category;
import com.ewsd.model.Comment;
import com.ewsd.model.Reaction;
import com.ewsd.model.User;

public class IdeaDto implements Serializable {

	private Long id;

	private String ideaTitle;

	private String ideaBody;

	private Category cat;

	private Boolean isDelete;

	private long totalLikes;

	private long totalDislikes;
	
	private long totalComment;
	
	private Integer reactionType;
	
	private Boolean isLiked;
	
	private Boolean isDisliked;
	
	private List<Comment> comments = new ArrayList<>();

	private List<Reaction> reactions = new ArrayList<>();

	private Set<Attachment> attachments = new HashSet<>();
	
	private User userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdeaTitle() {
		return ideaTitle;
	}

	public void setIdeaTitle(String ideaTitle) {
		this.ideaTitle = ideaTitle;
	}

	public String getIdeaBody() {
		return ideaBody;
	}

	public void setIdeaBody(String ideaBody) {
		this.ideaBody = ideaBody;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public long getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(long totalLikes) {
		this.totalLikes = totalLikes;
	}

	public long getTotalDislikes() {
		return totalDislikes;
	}

	public void setTotalDislikes(long totalDislikes) {
		this.totalDislikes = totalDislikes;
	}

	public long getTotalComment() {
		return totalComment;
	}

	public void setTotalComment(long totalComment) {
		this.totalComment = totalComment;
	}

	public Integer getReactionType() {
		return reactionType;
	}

	public void setReactionType(Integer reactionType) {
		this.reactionType = reactionType;
	}

	public Boolean getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Boolean getIsDisliked() {
		return isDisliked;
	}

	public void setIsDisliked(Boolean isDisliked) {
		this.isDisliked = isDisliked;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "IdeaDto [id=" + id + ", ideaTitle=" + ideaTitle + ", ideaBody=" + ideaBody + ", cat=" + cat
				+ ", isDelete=" + isDelete + ", totalLikes=" + totalLikes + ", totalDislikes=" + totalDislikes
				+ ", totalComment=" + totalComment + ", reactionType=" + reactionType + ", isLiked=" + isLiked
				+ ", isDisliked=" + isDisliked + ", comments=" + comments + ", reactions=" + reactions
				+ ", attachments=" + attachments + ", userId=" + userId + "]";
	}



}
