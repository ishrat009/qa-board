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
import org.springframework.web.bind.annotation.RequestParam;

import com.ewsd.dto.DepartmentDto;
import com.ewsd.model.Category;
import com.ewsd.model.Department;
import com.ewsd.request_models.CategoryRm;
import com.ewsd.service.DepartmentService;
import com.ewsd.service.UserService;
import com.ewsd.util.Util;

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
	public String add(Model model, @ModelAttribute("department") Department dept, Authentication authentication) {
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());

		LocalDateTime entry_date = LocalDateTime.now();

		DepartmentDto deptDto = new DepartmentDto();
		deptDto.setDeptName(dept.getDeptName());

		BeanUtils.copyProperties(deptDto, dept);
		
		dept.setEntryBy(deptDto.getEntryBy());
		dept.setEntryDate(entry_date);
		dept.setIsDelete(false);
		dept.setEntryBy(user);
		
		departmentService.edit(dept);

		model.addAttribute("message", "A new Department has been added Successfully");
		return "redirect:/department/add";
	}

	@GetMapping("/department/list")
	public String list_dept(Model model, Authentication authentication) {
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
		
		model.addAttribute("user", user);
		model.addAttribute("username", userName);
		model.addAttribute("departments", departmentService.getAll());
		
		model.addAttribute("message", "Showing All Departments");
		return "department/list";
	}

	@GetMapping("/department/edit")
	public String edit_GET(Model model, @RequestParam("id") long id, Authentication authentication) {
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("username", userName);

		var deptSer = departmentService.getById(id);
//		var dept = new Department();
//		
//		BeanUtils.copyProperties(deptSer, dept);
//		dept.setId(deptSer.getId());
//		dept.setDeptName(deptSer.getDeptName());
		
		model.addAttribute("deptSer", deptSer);
		return "department/edit";
	}

	@PostMapping("/department/edit")
	public String edit(Model model, @ModelAttribute("dept") Department dept, Authentication authentication) {
		LocalDateTime update_date = LocalDateTime.now();
		 org.springframework.security.core.userdetails.User authenticateduser  = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
		 
//		long deptId = departmentService.getById(deptId);

		Department deptEntity = new Department();
		var catDto = departmentService.getById(dept.getId());
		catDto.setDeptName(dept.getDeptName());
//		catDto.setId(deptId);
		BeanUtils.copyProperties(catDto,deptEntity);
		
		deptEntity.setEntryBy(catDto.getEntryBy());
		deptEntity.setEntryDate(catDto.getEntryDate());
		deptEntity.setUpdateDate(update_date);
		deptEntity.setIsDelete(true);
		deptEntity.setUpdateBy(user);;
		departmentService.edit(deptEntity);
		model.addAttribute("message", "Category Edited Successfully");
		return "redirect:/department/show-all";
	}

	@GetMapping("/department/deactive")
	public String soft_delete_GET(Model model, @RequestParam("id") long id) {
		// tagService.deactive(id);
		model.addAttribute("message", "Category Deactive successfully");
		return "redirect:/department/show-all";
	}
	
} // end of class
