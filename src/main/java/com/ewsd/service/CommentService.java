package com.ewsd.service;

import com.ewsd.dto.CommentDto;
import com.ewsd.model.Comment;
import com.ewsd.model.TermsAndConditions;
import com.ewsd.repositories.CommentRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
     CommentRepository commentRepository;



    public void addComment(Comment comment) {
//        LocalDateTime entry_date = LocalDateTime.now();
//        CommentDto comm = new CommentDto();
        comment.setCommentBody(comment.getCommentBody());
        //        comment.setCommentAt(entry_date);

//        BeanUtils.copyProperties(comm, comment);


        commentRepository.save(comment);
    }

    public List<Comment> getAll() {
        // TODO Auto-generated method stub
        return commentRepository.findAll();
    }
}
