package com.ewsd.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ewsd.dto.DepartmentDto;
import com.ewsd.model.Department;
import com.ewsd.service.DepartmentService;
import com.ewsd.service.UserService;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@Autowired
	UserService userService;

	@GetMapping("/department/add")
	public String add_dept(Model model, Authentication authentication) {
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("username", userName);
		model.addAttribute("department", new Department());
		return "department/add";
	}

	@PostMapping("/department/add")
	public String add(Model model, @ModelAttribute("department") Department department, Authentication authentication) {

		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());

		LocalDateTime update_date = LocalDateTime.now();

		DepartmentDto deptDto = new DepartmentDto();
		Department deptEntity = new Department();

		deptDto.setDeptName(department.getDeptName());

		BeanUtils.copyProperties(deptDto, deptEntity);
		
		deptEntity.setEntryBy(deptDto.getEntryBy());
		deptEntity.setEntryDate(deptEntity.getEntryDate());
		deptEntity.setUpdateDate(update_date);
		deptEntity.setIsDelete(true);
		deptEntity.setEntryBy(user);
		
		departmentService.edit(deptEntity);

		model.addAttribute("message", "A new Department has been added Successfully");
		return "redirect:/department/add";
	}

} // end of class
