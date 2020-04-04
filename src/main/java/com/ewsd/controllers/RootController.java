package com.ewsd.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ewsd.dto.UserDto;
import com.ewsd.enums.Role;
import com.ewsd.model.User;
import com.ewsd.repositories.UserRepository;
import com.ewsd.service.UserService;

@Controller
public class RootController {
	@Autowired
	UserService userService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public RootController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	/*
	 * @GetMapping("/") public String root() { return "index2"; }
	 */
	@GetMapping("/")
	public String root(Model model, Authentication authentication) {
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User u = userService.getUserByName(authenticateduser.getUsername());
		com.ewsd.model.User user = new com.ewsd.model.User();
		model.addAttribute("user", u);
		model.addAttribute("username", userName);
		return "index2";
	}
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error) {
		generateUsers();
		model.addAttribute("error", error);
		return "auth/login2";
	}

	private void generateUsers() {
		LocalDateTime e_date = LocalDateTime.now();
		if (userRepository.findByUsername("admin").isEmpty()) {
			var user = new User();
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("secret"));
			user.setRole(Role.ROLE_ADMIN);
			user.setEmail("admin@gmail.com");
			user.setFullName("QA Admin");
			user.setDept("Admin");
			user.setEntryDate(e_date);
			user.setActiveStatus(true);
			user.setIsExpired(true);
			user.setIsLocked(true);
			userRepository.save(user);
		}
		if (userRepository.findByUsername("qa_manager").isEmpty()) {
			var user = new User();
			user.setUsername("qa_manager");
			user.setPassword(passwordEncoder.encode("secret"));
			user.setRole(Role.ROLE_QAMANAGER);
			user.setEmail("manager@gmail.com");
			user.setFullName("QA Manager");
			user.setDept("QA");
			user.setEntryDate(e_date);
			user.setActiveStatus(true);
			user.setIsExpired(true);
			user.setIsLocked(true);
			userRepository.save(user);
		}
		if (userRepository.findByUsername("qa_coordinator").isEmpty()) {
			var user = new User();
			user.setUsername("qa_coordinator");
			user.setPassword(passwordEncoder.encode("secret"));
			user.setRole(Role.ROLE_QACOORDINATOR);
			user.setEmail("coordinator@gmail.com");
			user.setFullName("QA Coordinator");
			user.setDept("CSE");
			user.setEntryDate(e_date);
			user.setActiveStatus(true);
			user.setIsExpired(true);
			user.setIsLocked(true);
			userRepository.save(user);
		}

		if (userRepository.findByUsername("student").isEmpty()) {
			var user = new User();
			user.setUsername("student");
			user.setPassword(passwordEncoder.encode("secret"));
			user.setRole(Role.ROLE_STUDENT);
			user.setEmail("student@gmail.com");
			user.setFullName("QA Student");
			user.setDept("CSE");
			user.setEntryDate(e_date);
			user.setActiveStatus(true);
			user.setIsExpired(true);
			user.setIsLocked(true);
			userRepository.save(user);
		}
	}
	

	@GetMapping("/register")
	public String register(Model model, @RequestParam(name = "error", required = false) String error) {
		User user = new User();
		model.addAttribute("user", user);
		return "auth/register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		userDto.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.addUser(userDto);
		return "redirect:/login";
	//	return "auth/login2";
	}

	
}