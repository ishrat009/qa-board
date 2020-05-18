package com.ewsd.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ewsd.config.persistence.HibernateConfig;
import com.ewsd.exceptions.ResourceNotFoundException;
import com.ewsd.model.Category;
import com.ewsd.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	private HibernateConfig hibernateConfig;
	
	public TagService(HibernateConfig hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
	}

	public boolean add(Category catEntity) {
		if(!exists(catEntity.getName())) {
			tagRepository.save(catEntity);
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
	
	public Category getById(long catId) {

		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Category> sc = cb.createQuery(Category.class);
		Root<Category> root = sc.from(Category.class);
		sc.select(root);
		sc.where(
				cb.and(
						cb.equal(root.get("id"), catId),
						cb.isTrue(root.get("isDelete"))
				)
		);
		var query = session.getEntityManagerFactory().createEntityManager().createQuery(sc);
		var cat_list = query.getResultList();

		return Optional.ofNullable(cat_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("Tag Not Found With This Id"));
	}
	  public void edit(Category cat) {
		  tagRepository.save(cat);
	    }
}
