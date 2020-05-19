package com.ewsd.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ewsd.config.persistence.HibernateConfig;
import com.ewsd.dto.CommentDto;
import com.ewsd.dto.IdeaDto;
import com.ewsd.exceptions.ResourceNotFoundException;
import com.ewsd.model.Comment;
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
		if (findByIdeaTitle(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	public Idea findByIdeaTitle(String ideaTitle) {
		return ideaRepository.findByIdeaTitle(ideaTitle);
	}

	public void update(Idea idea) {
		ideaRepository.save(idea);
	}

	public List<Idea> getAll() {
		return (List<Idea>) ideaRepository.findAll();
	}

	public int count() {
		return getAll().size();
	}

	
	  public List<IdeaDto> getAllIdeaDtoWithCommentAndLike(long userId) {
	  
	  var session = hibernateConfig.getSession();
	  var transaction = session.getTransaction();
	  
	  if (!transaction.isActive()){ 
		  transaction = session.beginTransaction(); 
		  }
	  
	  CriteriaBuilder cb = session.getCriteriaBuilder(); 
	  CriteriaQuery<Idea> postCQ = cb.createQuery(Idea.class); 
	  Root<Idea> root = postCQ.from(Idea.class);
	  postCQ.select(root); 
	  var query = session.createQuery(postCQ);
	  
	  List<IdeaDto> resultList = new ArrayList<>();
	  
	  try { 
		  
		  query.getResultList().forEach(idea -> {
			  IdeaDto dto = new IdeaDto(); 
			  BeanUtils.copyProperties(idea,dto);
			  dto.setComments(idea.getComments()); 
			  dto.setReactions(idea.getReactions());
			  dto.setTotalComment(idea.getComments().size());
			  dto.setIsLiked(false);
			  dto.setIsDisliked(false);
			  
			  var likes = dto.getReactions();
			  
				  for(int i = 0,totalLikes=0,totalDislikes=0; i<likes.size(); i++){ 
					  if(likes.get(i).getReactionType()==2) {
						  totalLikes++;
						  dto.setTotalLikes(totalLikes);
						  if(likes.get(i).getUserId().getId() ==userId) {
							  dto.setIsLiked(true);
							//  break;
						  }
					  }
					  if(likes.get(i).getReactionType()==3) {
						  totalDislikes++;
						  dto.setTotalDislikes(totalDislikes);
						  if(likes.get(i).getUserId().getId() ==userId) {
							  dto.setIsDisliked(true);
						//	  break;
						  }
					  }
				
					 // System.out.println("I "+i);
					  }
				 				 
			  
			  
			  resultList.add(dto);
			  
	  
		  	});
	  
		  }catch (HibernateException e){ e.printStackTrace(); }finally {
			  session.close(); 
		  }
	//  System.out.println(resultList);
	  return resultList; 
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
		sc.where(cb.and(cb.equal(root.get("id"), ideaId), cb.isTrue(root.get("isDelete"))));
		var query = session.getEntityManagerFactory().createEntityManager().createQuery(sc);
		var idea_list = query.getResultList();
		return Optional.ofNullable(idea_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("Idea Not Found With This Id"));
	}

	@Transactional
	public long addNewComment(CommentDto commentDto) {
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}

		Comment comment = new Comment();
		BeanUtils.copyProperties(commentDto, comment);

		comment.setEntryDate(LocalDateTime.now());
		comment.setIsDelete(true);
		long commentId = 0;
		try {
			// session.save(comment);
			commentId = (long) session.save(comment);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

		return commentId;
	}

	public CommentDto getCommentById(long commentId) {
		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Comment> ccQuery = cb.createQuery(Comment.class);
		Root<Comment> root = ccQuery.from(Comment.class);

		ccQuery.where(cb.equal(root.get("id"), commentId));

		var query = session.createQuery(ccQuery);
	//	System.out.println(commentId);
//System.out.println(query.getSingleResult());
		Comment comment = new Comment();

		try {
			comment = query.getSingleResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		// System.out.println(comment);
		CommentDto commentDto = new CommentDto();
		BeanUtils.copyProperties(comment, commentDto);
		// System.out.println(commentDto);
		return commentDto;

	}
}
