package com.ewsd.controllers;

import com.ewsd.dto.TermsDto;
import com.ewsd.model.TermsAndConditions;
import com.ewsd.service.TermsAndConditionsService;
import com.ewsd.service.UserService;
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

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
class TermsAndConditionsController {

    @Autowired
    UserService userService;


    @Autowired
    TermsAndConditionsService termsAndConditionsService;

    @GetMapping("/termsAndCon/add")
    public String add_GET(Model model) {
//        var userName = authentication.getName();

//        model.addAttribute("username", userName);
        model.addAttribute("term", new TermsAndConditions());
        return "termsAndCon/add";
    }

    @PostMapping("/termsAndCon/add")
    public String add(Model model, @ModelAttribute("term") TermsAndConditions terms, Authentication authentication) {

            var  users = userService.getUserByName(authentication.getName());
//        var users = authentication.getName()
//        terms.setEntryBy(users);
//        terms.setUpdateBy(users);
//        terms.setEntryDate();
//        terms.setUpdateDate();

        termsAndConditionsService.addTerms(terms);
        model.addAttribute("message", "New termsAndCon Added Successfully");
        return "redirect:/termsAndCon/show-all";
    }
    @GetMapping("/termsAndCon/show-all")
    public String show_all(Model model, Authentication authentication) {
        var userName = authentication.getName();
        org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User u = userService.getUserByName(authenticateduser.getUsername());
        com.ewsd.model.User user = new com.ewsd.model.User();
        model.addAttribute("user", u);
        model.addAttribute("username", userName);
        model.addAttribute("termsAndConditions", new TermsAndConditions());
//        model.addAttribute("termsAndConditions", "TermsAndConditions");
        model.addAttribute("termsAndConditions_list", termsAndConditionsService.getAll());
        model.addAttribute("message", "Showing All Terms and Condition");
        return "termsAndCon/show-all";
    }


    @GetMapping("/termsAndCon/delete")
    public String soft_delete_GET(Model model, @RequestParam("id") Long id) {
        termsAndConditionsService.getDelete(id);
        model.addAttribute("message", "Category Deactive successfully");
        return "redirect:/termsAndCon/show-all";
    }

    @GetMapping("/termsAndCon/edit")
    public String edit_GET(Model model, @RequestParam("id")   Long id, Authentication authentication) {

        var userName = authentication.getName();
        org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute( "username", userName);

        Optional<TermsAndConditions> termOptional = termsAndConditionsService.getById(id);
        var  termDto= termOptional.get();
        TermsAndConditions termRm = new TermsAndConditions();
        BeanUtils.copyProperties(termDto, termRm);
        model.addAttribute("termRm", termRm);
        return "termsAndCon/edit";
    }

    @PostMapping("/termsAndCon/edit")
    public String edit(Model model, @ModelAttribute(name = "termRm") TermsAndConditions termRm) {

        LocalDateTime update_date = LocalDateTime.now();
        org.springframework.security.core.userdetails.User authenticateduser  = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());


        termsAndConditionsService.updateTerms(termRm);
        model.addAttribute("message", "termsAndCon Edited Successfully");
        return "redirect:/termsAndCon/show-all";
    }

}
