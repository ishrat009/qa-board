package com.ewsd.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import com.ewsd.dto.CommentDto;
import com.ewsd.model.Idea;
import com.ewsd.model.User;
import com.ewsd.request_models.CommentRm;
import com.ewsd.service.IdeaService;
import com.ewsd.service.ReactionService;

@RestController
@RequestMapping("/api/v1")
public class IdeaRestController {
	private Logger logger = Logger.getLogger(StudentController.class);
	@Autowired
	private IdeaService ideaService;
	@Autowired
	private ReactionService reactionService;

	@PostMapping("/idea/reactions")
	public ResponseEntity<?> addNewReaction(@RequestParam(name = "ideaId") long ideaId,
			@RequestParam(name = "userId") long userId, @RequestParam(name = "reactionType") long reactionType) {

		logger.info("userId: " + userId + " ideaId: " + ideaId);
		long reactionId = 0;
		boolean isExists = reactionService.isAlreadyReacted(ideaId, userId);
		if (isExists) {
			
			var existingReaction = reactionService.existingReactionDetail(ideaId, userId);
			if(existingReaction.getReactionType()!=reactionType) {
				reactionService.EditReaction(ideaId, userId, reactionType,existingReaction.getId());
				reactionId= existingReaction.getId();
				
			}
			else {
				long val = reactionService.removeReaction(ideaId, userId);
				logger.info("removed val: " + val);
			}
			

		} else {
			reactionId = reactionService.addNewReaction(ideaId, userId, reactionType);
			System.out.println(reactionId);
		}

		return new ResponseEntity<>(reactionId,HttpStatus.OK);
	}

	@PostMapping("/idea/addcomment")
	public ResponseEntity<?> addNewComment(@RequestParam(name = "ideaId") long ideaId,
			@RequestParam(name = "userId") long userId, @RequestParam(name = "commentBody") String commentBody) {
		Idea idea = new Idea();
		idea.setId(ideaId);
		User user = new User();
		user.setId(userId);
		CommentDto commentDto = new CommentDto();
		commentDto.setCommentBody(commentBody);
		commentDto.setUserId(user);
		commentDto.setIdeaId(idea);
		long commentId = ideaService.addNewComment(commentDto);
		var savedCommentDto = ideaService.getCommentById(commentId);

		CommentRm savedCommentRm = new CommentRm();
		BeanUtils.copyProperties(savedCommentDto, savedCommentRm);

		savedCommentRm.setId(savedCommentDto.getId());
		savedCommentRm.setIdeaId(savedCommentDto.getIdeaId().getId());
		savedCommentRm.setUserId(savedCommentDto.getUserId().getId());
		savedCommentRm.setCommentBody(savedCommentDto.getCommentBody());

		// return savedCommentRm;
		return new ResponseEntity<>(commentId, HttpStatus.OK);

	}

}
