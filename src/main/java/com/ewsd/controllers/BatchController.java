package com.ewsd.controllers;

import com.ewsd.model.Batch;
import com.ewsd.service.BatchService;
import com.ewsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BatchController {
    @Autowired
    private BatchService batchService;
    @Autowired
    UserService userService;
    @GetMapping("/batch/add")
    public String add_GET(Model model, Authentication authentication) {
        var userName = authentication.getName();
        org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User u = userService.getUserByName(authenticateduser.getUsername());
        com.ewsd.model.User user = new com.ewsd.model.User();
        model.addAttribute("user", u);
        model.addAttribute("username", userName);
        model.addAttribute("batch", new Batch());
        return "batch/add";
    }
    @PostMapping("/batch/add")
    public String add(Model model, @ModelAttribute("batch") Batch batch) {
        batchService.add(batch);
        model.addAttribute("message", "New batch Added Successfully");
        //return "category/add";
        return "redirect:/batch/show-all";
    }
    @GetMapping("/batch/show-all")
    public String show_all(Model model, Authentication authentication) {
        var userName = authentication.getName();
        org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User u = userService.getUserByName(authenticateduser.getUsername());
        com.ewsd.model.User user = new com.ewsd.model.User();
        model.addAttribute("user", u);
        model.addAttribute("username", userName);
        model.addAttribute("batch", new Batch());
        model.addAttribute("batch_list", batchService.getAll());
        model.addAttribute("message", "Showing All Batch");
        return "batch/show-all";
    }
    @GetMapping("/batch/edit")
    public String edit_GET(Model model, @RequestParam("id") long id) {
        //	Category cat = tagService.getById(id);
        return "batch/edit";
    }

    @PostMapping("/batch/edit")
    public String edit(Model model, @ModelAttribute(name = "batch") Batch batch) {
        //tagService.edit(cat);
        model.addAttribute("message", "Batch Edited Successfully");
        return "redirect:/batch/show-all";
    }

    @GetMapping("/batch/deactive")
    public String soft_delete_GET(Model model, @RequestParam("id") long id) {
        //tagService.deactive(id);
        model.addAttribute("message", "Batch Deactive successfully");
        return "redirect:/batch/show-all";
    }
}
