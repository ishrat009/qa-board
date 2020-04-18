package com.ewsd.controllers;

import com.ewsd.model.Comment;
import com.ewsd.model.TermsAndConditions;
import com.ewsd.service.CommentService;
import com.ewsd.service.TermsAndConditionsService;
import com.ewsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {



    @Autowired
    UserService userService;


    @Autowired
    CommentService commentService;

    @GetMapping("/comment/add")
    public String add_GET(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/add";
    }

    @PostMapping("/comment/add")
    public String add(Model model, @ModelAttribute("comment") Comment comment, Authentication authentication) {

//        var  users = userService.getUserByName(authentication.getName());
//        var users = authentication.getName()
//        terms.setEntryBy(users);
//        terms.setUpdateBy(users);
//        terms.setEntryDate();
//        terms.setUpdateDate();

        commentService.addComment(comment);
        model.addAttribute("message", "New Comment Added Successfully");
        return "comment/show-all";
//        return "redirect:/comment/show-all";
    }

    @GetMapping("/comment/show-all")
     public String show_all(Model model, Authentication authentication) {
        var userName = authentication.getName();
        org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User u = userService.getUserByName(authenticateduser.getUsername());
        com.ewsd.model.User user = new com.ewsd.model.User();
        model.addAttribute("user", u);
        model.addAttribute("username", userName);
        model.addAttribute("comment", new Comment());
//        model.addAttribute("termsAndConditions", "TermsAndConditions");
        model.addAttribute("comment_list", commentService.getAll());
        model.addAttribute("message", "Showing All Comment");
        return "comment/show-all";
    }
}
