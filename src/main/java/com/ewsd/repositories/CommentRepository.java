package com.ewsd.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewsd.model.Comment;
import com.ewsd.model.Idea;
import com.ewsd.model.User;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	//Comment findByIdeaAndCommentedUser(Idea idea, User userByUsername);

	//List<Comment> findAllByIdea(Idea idea);
}
