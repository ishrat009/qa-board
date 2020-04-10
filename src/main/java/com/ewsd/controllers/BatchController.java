package com.ewsd.controllers;

import com.ewsd.dto.BatchDto;
import com.ewsd.dto.CategoryDto;
import com.ewsd.model.Batch;
import com.ewsd.model.Category;
import com.ewsd.request_models.BatchRm;
import com.ewsd.request_models.CategoryRm;
import com.ewsd.service.BatchService;
import com.ewsd.service.UserService;
import com.ewsd.util.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Optional;

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
        model.addAttribute("batch", new Batch());  //todo:batch to batchrm
        return "batch/add";
    }

    @PostMapping("/batch/add")
    public String add(Model model, @ModelAttribute("batchRm") Batch batch, Authentication authentication) {
        /*var userName = authentication.getName();
        LocalDateTime entry_date = LocalDateTime.now();
        org.springframework.security.core.userdetails.User authenticateduser  = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());

        System.out.println(batchRm.toString());
       *//* var deptId = departmentService.getById(catRm.getDeptId());
        System.out.println(deptId);*//*
        BatchDto batchDto = new BatchDto();
        Batch batchEntity = new Batch();
       *//* batchDto.setOpeningDate(Util.getFormattedDate(batchRm.getOpeningDate(), Util.DOB_DATE_FORMAT));
        batchDto.setClosingDate(Util.getFormattedDate(batchRm.getClosingDate(), Util.DOB_DATE_FORMAT));
        batchDto.setFinalClosingDate(Util.getFormattedDate(batchRm.getFinalClosingDate(), Util.DOB_DATE_FORMAT));
        batchDto.setName(catRm.getName());
        batchDto.setDept(deptId);*//*
        BeanUtils.copyProperties(batchDto,batchEntity);
        batchEntity.setEntryDate(entry_date);
        batchEntity.setIsDelete(true);
        batchEntity.setEntryBy(user);*/
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
        model.addAttribute("batch", new Batch());  //todo:batch to batchrm
        model.addAttribute("batch_list", batchService.getAll());
        model.addAttribute("message", "Showing All Batch");
        return "batch/show-all";
    }
    @GetMapping("/batch/edit")
    public String edit_GET(Model model, @RequestParam("id") Long id, Authentication authentication) {
        //	Category cat = tagService.getById(id);
        Optional<Batch> batch=batchService.getById(id);
        var userName = authentication.getName();
        org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("username", userName);
        Optional<Batch> batchOptional=batchService.getById(id);
        var batchDto = batchOptional.get();
      //  var batchRm = new Batch();
        Batch batchRm=new Batch();
        BeanUtils.copyProperties(batchDto, batchRm);
        //batchRm.setBatchName(batchDto.get());
     //   batchRm.setAcademicYear(batchDto.get().getAcademicYear());
       // batchRm.setDeptId(catDto.getDept().getId());
       // catRm.setDeptName(catDto.getDept().getDeptName());
       // batchRm.setBatchName(batchDto);
      /*  batchRm.setOpeningDate(Util.getStringDate(batchDto.getOpeningDate(), Util.DOB_DATE_FORMAT));
        batchRm.setClosingDate(Util.getStringDate(batchDto.getClosingDate(), Util.DOB_DATE_FORMAT));
        batchRm.setFinalClosingDate(Util.getStringDate(batchDto.getFinalClosingDate(), Util.DOB_DATE_FORMAT));*/
        model.addAttribute("batchedit", batchRm);
      //  model.addAttribute("dept_list", departmentService.getAll());
        return "batch/edit";


    }

    @PostMapping("/batch/edit")
    public String edit(Model model, @ModelAttribute(name = "batch") Batch batchRm) {
        //tagService.edit(cat);
        LocalDateTime update_date = LocalDateTime.now();
        org.springframework.security.core.userdetails.User authenticateduser  = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());

        System.out.println(batchRm.toString());
       // var deptId = departmentService.getById(batchRm.getDeptId());
       // System.out.println(deptId);
        //CategoryDto catDto = new CategoryDto();
       // Batch batchEntity = new Batch();
        //var batchDto = batchService.getById(batchRm.getId());
      /*  batchDto.setOpeningDate(Util.getFormattedDate(batchRm.getOpeningDate(), Util.DOB_DATE_FORMAT));
        batchDto.setClosingDate(Util.getFormattedDate(batchRm.getClosingDate(), Util.DOB_DATE_FORMAT));
        batchDto.setFinalClosingDate(Util.getFormattedDate(batchRm.getFinalClosingDate(), Util.DOB_DATE_FORMAT));*/
        /*batchDto.setBatchName(batchRm.getBatchName());
        //batchDto.setDept(deptId);
        BeanUtils.copyProperties(batchDto,batchEntity);

        batchEntity.setEntryBy(batchDto.getEntryBy());
        batchEntity.setEntryDate(batchDto.getEntryDate());
        batchEntity.setUpdateDate(update_date);
        batchEntity.setIsDelete(true);
        batchEntity.setUpdateBy(user);;*/
        batchService.edit(batchRm);
        model.addAttribute("message", "Batch Edited Successfully");
        return "redirect:/batch/show-all";

    }
    /*@RequestMapping("batch/edittwo")
    public ModelAndView editBatchForm(@RequestParam Long id){
        ModelAndView modelAndView=new ModelAndView("batch/edit")
                Batch batchedit=batchService.getById(id);
        modelAndView.addAllObjects("batchedit",batchedit)
    }*/

    @GetMapping("/batch/delete")
    public String soft_delete_GET(Model model, @RequestParam("id") Long id) {
        batchService.getDelete(id);
        model.addAttribute("message", "Batch Deactive successfully");
        return "redirect:/batch/show-all";
    }
}
