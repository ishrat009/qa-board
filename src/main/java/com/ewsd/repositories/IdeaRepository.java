package com.ewsd.repositories;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ewsd.model.Idea;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long>{

	Idea findByIdeaTitle(String ideaTitle);
	Idea findAllByAuthorEmailOrderByIdDesc(String email);

//	List<Idea> findAllByAuthorEmail(String email);
	
	@Query("select i from Idea i")
	Page<Idea> findAll(Pageable page);

	//List<Idea> findAllByCategory(Category cat);

//	List<Idea> findByCategory(Category cat);
}
