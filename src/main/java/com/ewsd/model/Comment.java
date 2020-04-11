package com.ewsd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_comment")
public class Comment implements Serializable {

    @Id
    @Column(name = "Id", length = 20, nullable = false)
    private Long id;

    @Column(name = "comment_body")
    private String commentBody;

    @Column(name = "commentAt")
    private LocalDateTime commentAt;

    public Comment() {

    }

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

    public LocalDateTime getCommentAt() {
        return commentAt;
    }

    public void setCommentAt(LocalDateTime commentAt) {
        this.commentAt = commentAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentBody='" + commentBody + '\'' +
                ", commentAt=" + commentAt +
                '}';
    }
}