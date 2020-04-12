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
	
	@GetMapping("/resetPassword")
	public String resetPassword_GET(Model model) {
		User user = new User();
		model.addAttribute("ok", "");
		model.addAttribute("user", user);
		return "/auth/reset_password";
	}
	
	@PostMapping("/resetPassword")
	public String resetPassword(Model model, @RequestParam("email") String email) {
		if (userService.existsWithEmail(email)) {
			userService.sendPasswordResetLink(email);
			model.addAttribute("ok", "true");
		} else {
			model.addAttribute("ok", "invalid-email");
		}
		return "/auth/reset_password";
	}
	
/*
 * 	@RequestMapping(value = "/reset-password", method = RequestMethod.GET)
	public String resetPassword_GET(Model model) {
		model.addAttribute("ok", "");
		return "/templates/reset_password";
	}

	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public String resetPassword_POST(Model model, @RequestParam("email") String email) {
		if (userService.existsWithEmail(email)) {
			userService.sendPasswordResetLink(email);
			model.addAttribute("ok", "true");
		} else {
			model.addAttribute("ok", "invalid-email");
		}
		return "/templates/reset_password";
	}

	@RequestMapping(value = "/update-password", method = RequestMethod.GET)
	public String updatePassword_GET(Model model, @RequestParam("id") String username,
			@RequestParam("adp") Long timestamp) {
		long currentMinutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
		long minutesWhenRequested = TimeUnit.MILLISECONDS.toMinutes(timestamp);
		System.out.println(currentMinutes - minutesWhenRequested);
		if (currentMinutes - minutesWhenRequested > 2) {
			model.addAttribute("ok", "false");
			return "/templates/reset_password";
		}
		model.addAttribute("id", username);
		model.addAttribute("ok", "");
		return "/templates/update_password";
	}

	@RequestMapping(value = "/update-password", method = RequestMethod.POST)
	public String updatePassword_POST(Model model, @RequestParam("id") String username,
			@RequestParam("password") String password, @RequestParam("re_password") String rePassword) {
		UserEntity userEntity = userService.getUserByUsername(username);
		if (password.equals(rePassword)) {
			userEntity.setPassword(encoder.encode(password));
			System.out.println(password);
			userService.updateUser(userEntity);
			model.addAttribute("ok", "true");
		} else {
			model.addAttribute("ok", "false");
		}

		return "/templates/update_password";
	}

 * 
 * 
 */
	
}