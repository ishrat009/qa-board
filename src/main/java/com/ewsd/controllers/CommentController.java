package com.ewsd.controllers;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ewsd.dto.CommentDto;
import com.ewsd.model.Comment;
import com.ewsd.model.Idea;
import com.ewsd.request_models.CommentRm;
import com.ewsd.service.CommentService;
import com.ewsd.service.IdeaService;
import com.ewsd.service.UserService;

@Controller
public class CommentController {
	@Autowired
	IdeaService ideaService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/idea/addComment")
	public String addComment(@ModelAttribute(name = "commentRm") CommentRm commentRm, Model model,
			Authentication auth) {

		var username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		var user = userService.getUserByUserName(username).get();
		commentRm.setUserId(user.getId());
		//ideaService.insertComment(commentDto);
		model.addAttribute("message", "Comment added successfully");
		return "redirect:/test/show-all";
	}
	 @PostMapping("/idea/{ideaId}/comments")
	 @ResponseBody
    public ResponseEntity<List<Comment>> comments_POST(@PathVariable("ideaId") Long ideaId,
	            @ModelAttribute(name = "commentRm") CommentRm commentRm, Model model,
				Authentication auth
	    ) {
			var username = "";
			LocalDateTime entry_date = LocalDateTime.now();
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}
			var user = userService.getUserByUserName(username).get();
			commentRm.setUserId(user.getId());
	        
	        List<Comment> comments = new ArrayList<>();
	        System.out.println(commentRm);
	        Idea idea = ideaService.getById(ideaId);
	        if (commentRm.getCommentBody().isEmpty() == false) {
	        	commentRm.setIdea(ideaService.getById(ideaId));
	        //	commentRm.setAnonymous(isAnonymous);
	        	CommentDto cDto = new CommentDto();
	        	Comment cEntity = new Comment();
	        	cDto.setCommentBody(commentRm.getCommentBody());
	        	cDto.setIdeaId(commentRm.getIdea());
	        	cDto.setUserId(user);
	        	BeanUtils.copyProperties(cDto, cEntity);
	        	cEntity.setEntryDate(entry_date);
	        	cEntity.setIsDelete(true);
	        	commentService.save(cEntity);
	            
	            //comments.add(commentRm);
	            //idea.getComments().add(comment);
	           // ideaService.update(idea);

	            InetAddress IP = null;
	            try {
	                IP = Inet4Address.getLocalHost();
	            } catch (UnknownHostException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	           
	            List<Comment> comments2 = new ArrayList<>();
	            for (Comment comment2 : idea.getComments()) {
	                comments2.add(comment2);
	            }
	         //   logger.info("Comment posted");
	            return new ResponseEntity<List<Comment>>(comments2, HttpStatus.OK);
	        } else if (commentRm.getCommentBody().isEmpty()) {
	            return new ResponseEntity<List<Comment>>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<List<Comment>>(HttpStatus.NOT_ACCEPTABLE);
	        }

	    }

}
