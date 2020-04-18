package com.ewsd.repositories;

import com.ewsd.model.Comment;
import com.ewsd.model.TermsAndConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment getById (Long id);
}
