package com.ewsd.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ewsd.model.Attachment;
import com.ewsd.model.Category;
import com.ewsd.model.Comment;
import com.ewsd.model.Reaction;

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
	
	private List<Comment> comments = new ArrayList<>();

	private List<Reaction> reactions = new ArrayList<>();

	private List<Attachment> attachments = new ArrayList<>();

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

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "IdeaDto [id=" + id + ", ideaTitle=" + ideaTitle + ", ideaBody=" + ideaBody + ", cat=" + cat
				+ ", isDelete=" + isDelete + ", totalLikes=" + totalLikes + ", totalDislikes=" + totalDislikes
				+ ", totalComment=" + totalComment + ", reactionType=" + reactionType + ", comments=" + comments
				+ ", reactions=" + reactions + ", attachments=" + attachments + "]";
	}
	
}
