package com.ewsd.service;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewsd.config.persistence.HibernateConfig;
import com.ewsd.model.Idea;
import com.ewsd.model.Reaction;
import com.ewsd.model.User;
import com.ewsd.repositories.ReactionRepository;

@Service
public class ReactionService {

	@Autowired
	private ReactionRepository reactionRepository;

	@Autowired
	private IdeaService ideaService;

	@Autowired
	private UserService userService;
	private HibernateConfig hibernateConfig;

	public ReactionService(HibernateConfig hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
	}
	/*
	 * public Reaction findOne(Long id) { return reactionRepository.findOne(id); }
	 */

	public void save(Reaction reaction) {
		reactionRepository.save(reaction);
	}

	/*
	 * public boolean exists(Long userId, Long ideaId) { for(Reaction reaction :
	 * ideaService.getById(ideaId).getReactions()) {
	 * if(reaction.getUserId().getId().equals(userId)) { return true; } } return
	 * false; }
	 * 
	 * public Reaction fetch(Long ideaId, String username) { // TODO Auto-generated
	 * method stub return
	 * reactionRepository.findByIdeaAndReactedUser(ideaService.getById(ideaId),
	 * userService.getUserByName(username)); }
	 */
	public long addNewReaction(long ideaId, long userId, long reactionType) {
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}

		Reaction reaction = new Reaction();

		Idea idea = new Idea();
		idea.setId(ideaId);
		User user = new User();
		user.setId(userId);
		
		reaction.setIdeaId(idea);
		reaction.setUserId(user);
		if(reactionType==2) {
			reaction.setReactionType(2);
		}if(reactionType==3) {
			reaction.setReactionType(3);
		}
		

		long reactionId = 0;
		try {
			reactionId = (long) session.save(reaction);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return reactionId;
	}
	public void EditReaction(long ideaId, long userId, long reactionType,long Id) {
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}

		Reaction reaction = new Reaction();

		Idea idea = new Idea();
		idea.setId(ideaId);
		User user = new User();
		user.setId(userId);
		reaction.setId(Id);
		reaction.setIdeaId(idea);
		reaction.setUserId(user);
		if(reactionType==2) {
			reaction.setReactionType(2);
		}if(reactionType==3) {
			reaction.setReactionType(3);
		}
		
		try {
			session.update(reaction);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		
	}

	public boolean isAlreadyReacted(long ideaId, long userId) {

		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Reaction> likeCQ = cb.createQuery(Reaction.class);
		Root<Reaction> root = likeCQ.from(Reaction.class);

		likeCQ.where(cb.and(cb.equal(root.get("ideaId"), ideaId), cb.equal(root.get("userId"), userId)));

		var query = session.createQuery(likeCQ);

		var likeList = new ArrayList<Reaction>();

		try {
			likeList = (ArrayList<Reaction>) query.getResultList();
			transaction.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		if (likeList.size() <= 0) {
			return false;
		} else {
			return true;
		}

	}
	public Reaction existingReactionDetail(long ideaId, long userId) {

		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Reaction> likeCQ = cb.createQuery(Reaction.class);
		Root<Reaction> root = likeCQ.from(Reaction.class);

		likeCQ.where(cb.and(cb.equal(root.get("ideaId"), ideaId), cb.equal(root.get("userId"), userId)));

		var query = session.createQuery(likeCQ);

	//	var likeList = new ArrayList<Reaction>();
		Reaction reaction = new Reaction();
		try {
			reaction = query.getSingleResult();
			

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return reaction;

	}

	@Transactional
	public long removeReaction(long ideaId, long userId) {

		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Reaction> criteriaDelete = cb.createCriteriaDelete(Reaction.class);
		Root<Reaction> root = criteriaDelete.from(Reaction.class);

		Idea idea = new Idea();
		idea.setId(ideaId);
		criteriaDelete.where(cb.and(cb.equal(root.get("ideaId"), ideaId), cb.equal(root.get("userId"), userId)));

		var query = session.createQuery(criteriaDelete);

		long val = 0;

		try {
			val = query.executeUpdate();
			transaction.commit();

		} catch (HibernateException e) {

			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		return val;

	}
}
