package com.ewsd.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDto implements Serializable {


    private Long commentId;

    private String commentBody;


    private LocalDateTime commentAt;
//todo: test
    public CommentDto() {

    }

    public CommentDto(Long commentId, String commentBody, LocalDateTime commentAt) {
        this.commentId = commentId;
        this.commentBody = commentBody;
        this.commentAt = commentAt;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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
}