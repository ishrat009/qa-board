package com.ewsd.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_idea")
public class Idea implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", length = 20, nullable = false)
	private Long id;

	@Column(name = "idea_title", length = 200, nullable = false)
	private String ideaTitle;

	@Column(name = "idea_body", nullable = false)
	private String ideaBody;

	@Column(name = "author_email", length = 200, nullable = false)
	private String authorEmail;

	@Column(name = "total_viws")
	private Integer countViews = 0;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ideaId", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ideaId", cascade = CascadeType.ALL)
	private List<Reaction> reactions;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Attachment.class)
	@JoinTable(name = "idea_attachments", joinColumns = @JoinColumn(name = "idea_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "attachments_id", referencedColumnName = "id"))
	private Set<Attachment> attachments;

	@ManyToOne
	private Category cat;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "idea_seen_by")
	private Set<String> seenBy = new HashSet<>();

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

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public Integer getCountViews() {
		return countViews;
	}

	public void setCountViews(Integer countViews) {
		this.countViews = countViews;
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

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public Set<String> getSeenBy() {
		return seenBy;
	}

	public void setSeenBy(Set<String> seenBy) {
		this.seenBy = seenBy;
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

	public Idea(Long id, String ideaTitle, String ideaBody, String authorEmail, Integer countViews,
			List<Comment> comments, List<Reaction> reactions, Set<Attachment> attachments, Category cat,
			Set<String> seenBy, User userId, LocalDateTime entryDate, LocalDateTime updateDate, Boolean isDelete) {
		super();
		this.id = id;
		this.ideaTitle = ideaTitle;
		this.ideaBody = ideaBody;
		this.authorEmail = authorEmail;
		this.countViews = countViews;
		this.comments = comments;
		this.reactions = reactions;
		this.attachments = attachments;
		this.cat = cat;
		this.seenBy = seenBy;
		this.userId = userId;
		this.entryDate = entryDate;
		this.updateDate = updateDate;
		this.isDelete = isDelete;
	}

	public Idea() {
		super();
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", ideaTitle=" + ideaTitle + ", ideaBody=" + ideaBody + ", authorEmail=" + authorEmail
				+ ", countViews=" + countViews + ", comments=" + comments + ", reactions=" + reactions
				+ ", attachments=" + attachments + ", cat=" + cat + ", seenBy=" + seenBy + ", userId=" + userId
				+ ", entryDate=" + entryDate + ", updateDate=" + updateDate + ", isDelete=" + isDelete + "]";
	}



}
