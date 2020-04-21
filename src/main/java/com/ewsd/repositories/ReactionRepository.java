package com.ewsd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewsd.model.Idea;
import com.ewsd.model.Reaction;
import com.ewsd.model.User;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

//	Reaction findByIdeaAndReactedUser(Idea idea, User userByUsername);

}
