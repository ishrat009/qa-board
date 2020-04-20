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
		//Player playerEntity = new Player();
	  //  BeanUtils.copyProperties(playerDto,playerEntity);
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

	/*
	 * public boolean add(Idea ideaEntity) { if(!exists(ideaEntity.getIdeaTitle()))
	 * { ideaRepository.saveOrUpdate(ideaEntity); ideaRepository.save(ideaEntity);
	 * return true; }else { return false; } }
	 */
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
	
	/*
	 * public List<Idea> listIdeasByTag(Category tag){ return (List<Idea>)
	 * ideaRepository.findByCategory(tag); }
	 */
	
	/*
	 * public Page<Idea> listAllIdeasByAuthorEmail(String authorEmail, int
	 * pageNumber, int resultPerPage){ return
	 * ideaRepository.findAllByAuthorEmailOrderByIdeaIdDesc(authorEmail,
	 * getPage(pageNumber, resultPerPage)); }
	 */
	
	/*
	 * public List<Idea> listAllIdeasByAuthorEmail(String authorEmail){ return
	 * ideaRepository.findAllByAuthorEmail(authorEmail); }
	 */
	
	/*
	 * public PageRequest getPage(int pageNumber, int resultPerPage) { PageRequest
	 * request = new PageRequest(pageNumber - 1, resultPerPage, Sort.Direction.DESC,
	 * "ideaId"); return request; }
	 */
	
	public int count(){
        return getAll().size();
    }
	
	/*
	 * public int count(String authorEmail, int pageNumber, int resultPerPage) {
	 * return listAllIdeasByAuthorEmail(authorEmail, pageNumber,
	 * resultPerPage).getContent().size(); }
	 * 
	 * public int count(int pageNumber, int resultPerPage) { return
	 * ideaRepository.findAll(getPage(pageNumber,
	 * resultPerPage)).getContent().size(); }
	 */
	
	/*
	 * public Idea getIdea(Long ideaId) { return ideaRepository.findOne(ideaId); }
	 */
	
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
	/*
	 * public Page<Idea> getPageOfIdeas(int pageNumber, int resultPerPage) { // TODO
	 * Auto-generated method stub return ideaRepository.findAll(getPage(pageNumber,
	 * resultPerPage)); }
	 */
	/*
	 * public List<Idea> ideasByTag(Category cat){ return
	 * ideaRepository.findAllByCategory(cat); }
	 */
}
