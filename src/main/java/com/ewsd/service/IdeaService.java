package com.ewsd.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ewsd.config.persistence.HibernateConfig;
import com.ewsd.exceptions.ResourceNotFoundException;
import com.ewsd.model.Idea;
import com.ewsd.repositories.IdeaRepository;


@Service
public class IdeaService {
	@Autowired
	IdeaRepository ideaRepository;
	private HibernateConfig hibernateConfig;
	
	public IdeaService(HibernateConfig hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
	}
	@Transactional
	public void add(Idea ideaEntity) {
		
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		try {
			session.save(ideaEntity);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public boolean exists(String name) {
		if(findByIdeaTitle(name)!=null) {
			return true;
		}else {
			return false;
		}
	}
	public Idea findByIdeaTitle(String ideaTitle) {
		return ideaRepository.findByIdeaTitle(ideaTitle);
	}
	public void update(Idea idea) {
		ideaRepository.save(idea);
	}

	public List<Idea> getAll(){
		return (List<Idea>) ideaRepository.findAll();
	}
	
	
	
	public int count(){
        return getAll().size();
    }

	public Idea getById(long ideaId) {
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Idea> sc = cb.createQuery(Idea.class);
		Root<Idea> root = sc.from(Idea.class);
		sc.select(root);
		sc.where(
				cb.and(
						cb.equal(root.get("id"), ideaId),
						cb.isTrue(root.get("isDelete"))
				)
		);
		var query = session.getEntityManagerFactory().createEntityManager().createQuery(sc);
		var idea_list = query.getResultList();
		return Optional.ofNullable(idea_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("Idea Not Found With This Id"));
	}
	
}
