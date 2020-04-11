package com.ewsd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ewsd.model.Category;
import com.ewsd.service.TagService;
import com.ewsd.service.UserService;


@Controller
public class QAManagerController {
	
	@Autowired
	private TagService tagService;

	@Autowired
	UserService userService;
	
	@GetMapping("/category/add")
	public String add_GET(Model model, Authentication authentication) {
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User u = userService.getUserByName(authenticateduser.getUsername());
		com.ewsd.model.User user = new com.ewsd.model.User();
		model.addAttribute("user", u);
		model.addAttribute("username", userName);
		model.addAttribute("cat", new Category());
		return "category/add";
	}

	@PostMapping("/category/add")
	public String add(Model model, @ModelAttribute("cat") Category cat) {
		tagService.add(cat);
		model.addAttribute("message", "New Category Added Successfully");
		//return "category/add";
		return "redirect:/category/show-all";
	}

	@GetMapping("/category/show-all")
	public String show_all(Model model, Authentication authentication) {
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User u = userService.getUserByName(authenticateduser.getUsername());
		com.ewsd.model.User user = new com.ewsd.model.User();
		model.addAttribute("user", u);
		model.addAttribute("username", userName);
		model.addAttribute("cat", new Category());
		model.addAttribute("cat_list", tagService.getAll());
		model.addAttribute("message", "Showing All Category");
		return "category/show-all";
	}

	@GetMapping("/category/edit")
	public String edit_GET(Model model, @RequestParam("id") long id) {
//		Category cat = tagService.getById(id);
		return "category/edit";
	}

	@PostMapping("/category/edit")
	public String edit(Model model, @ModelAttribute(name = "cat") Category cat) {
		//tagService.edit(cat);
		model.addAttribute("message", "Category Edited Successfully");
		return "redirect:/category/show-all";
	}

	@GetMapping("/category/deactive")
	public String soft_delete_GET(Model model, @RequestParam("id") long id) {
		//tagService.deactive(id);
		model.addAttribute("message", "Category Deactive successfully");
		return "redirect:/category/show-all";
	}
}
