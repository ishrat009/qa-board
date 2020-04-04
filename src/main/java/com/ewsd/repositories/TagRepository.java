package com.ewsd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ewsd.model.Category;

public interface TagRepository extends JpaRepository<Category, Long>{

	Category findByName(String name);
	

}
