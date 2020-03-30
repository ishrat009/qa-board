package com.ewsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewsd.model.Category;
import com.ewsd.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public boolean add(Category cat) {
		if(!exists(cat.getName())) {
			tagRepository.save(cat);
			return true;
		}else {
			return false;
		}
	}
	
	public Category findByName(String name) {
		return tagRepository.findByName(name);
	}
	
	public boolean exists(String name) {
		if(findByName(name)!=null) {
			return true;
		}else {
			return false;
		}
	}

	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return tagRepository.findAll();
	}

	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return tagRepository.getOne(id);
	}

	public boolean delete(Category cat) {
		// TODO Auto-generated method stub
		tagRepository.delete(cat);
		return true;
	}
}
