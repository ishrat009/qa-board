package com.ewsd.request_models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ewsd.model.Attachment;

public class IdeaRm implements Serializable  {
	
	private Long id;
	
	private String ideaTitle;
	
	private String ideaBody;
	
	private Long catId;
	
	private String catName;
	
	private List<Attachment> attachments = new ArrayList<>();
	
	private Boolean isDelete;
	
	private List<CommentRm> commentRMS = new ArrayList<>();
	
    private List<ReactionRm> reactionList = new ArrayList<>();
    
    private long totalLikes;
	
	private long totalDislikes;
	
	private long totalComment;
	
	private Integer reactionType;

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

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public List<CommentRm> getCommentRMS() {
		return commentRMS;
	}

	public void setCommentRMS(List<CommentRm> commentRMS) {
		this.commentRMS = commentRMS;
	}

	public List<ReactionRm> getReactionList() {
		return reactionList;
	}

	public void setReactionList(List<ReactionRm> reactionList) {
		this.reactionList = reactionList;
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

	@Override
	public String toString() {
		return "IdeaRm [id=" + id + ", ideaTitle=" + ideaTitle + ", ideaBody=" + ideaBody + ", catId=" + catId
				+ ", catName=" + catName + ", attachments=" + attachments + ", isDelete=" + isDelete + ", commentRMS="
				+ commentRMS + ", reactionList=" + reactionList + ", totalLikes=" + totalLikes + ", totalDislikes="
				+ totalDislikes + ", totalComment=" + totalComment + ", reactionType=" + reactionType + "]";
	}
	
	
}
