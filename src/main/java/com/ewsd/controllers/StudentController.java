package com.ewsd.controllers;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.multipart.MultipartFile;

import com.ewsd.dto.IdeaDto;
import com.ewsd.model.Attachment;
import com.ewsd.model.Idea;
import com.ewsd.request_models.IdeaRm;
import com.ewsd.service.AttachmentService;
import com.ewsd.service.IdeaService;
import com.ewsd.service.TagService;
import com.ewsd.service.UserService;

@Controller
public class StudentController {
	@Autowired
	UserService userService;
	@Autowired
	TagService tagService;
	@Autowired
	private IdeaService ideaService;
	@Autowired
	private AttachmentService attachmentService;

	@GetMapping("/idea/add")
	public String postNewIdea_GET(Model model, Authentication authentication) {

		/*
		 * if(!notificationId.isEmpty() && Character.isDigit(notificationId.charAt(0)))
		 * { Notification notification =
		 * notificationService.findById(Long.parseLong(notificationId));
		 * notification.setSeen("yes"); notificationService.save(notification); }
		 */
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("username", userName);
		model.addAttribute("ideaRm", new IdeaRm());
		model.addAttribute("cat_list", tagService.getAll());
	//	System.out.println(tagService.getAll());
		// List<Category> cats = tagService.getAll();
		// cats.removeIf(cat -> cats.getClosingDate() == null ||
		// cats.getClosingDate().getTime() < System.currentTimeMillis()
		// || !cat.getDepartments().contains(user.getDepartment()));

		// model.addAttribute("categories", cats);
		// logger.info("Student -> Post new idea : ");
		return "/idea/add";
	}

	@PostMapping("/idea/add")
	public String postNewIdea_POST(Model model, @ModelAttribute("ideaRm") IdeaRm ideaRm, Authentication authentication,
			@RequestParam("images[]") MultipartFile[] files) {
		LocalDateTime entry_date = LocalDateTime.now();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());

		var catId = tagService.getById(ideaRm.getCatId());
		System.out.println(catId);
		IdeaDto ideaDto = new IdeaDto();
		Idea ideaEntity = new Idea();
		ideaDto.setIdeaTitle(ideaRm.getIdeaTitle());
		ideaDto.setIdeaBody(ideaRm.getIdeaBody());
		ideaDto.setCat(catId);

		InetAddress IP = null;
		try {
			IP = Inet4Address.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Attachment> attachments = new HashSet<Attachment>();
		if (files[0].getOriginalFilename().contains(".")) {
			for (MultipartFile file : files) {
				if (file.getSize() > 25000000L) {
					model.addAttribute("ideaRm", new IdeaRm());
					model.addAttribute("usr", user);
					model.addAttribute("cat_list", tagService.getAll());
					model.addAttribute("ok", "false");
					model.addAttribute("msg", "Sorry, The file size is too large.");
					return "/idea/add";
				}
				System.out.println(file.getContentType());
				if (!file.getContentType().contains("image") && !file.getOriginalFilename().contains(".doc")
						&& !file.getOriginalFilename().contains(".docx") && !file.getContentType().contains("video")
						&& !file.getOriginalFilename().contains(".pdf")) {
					System.out.println(file.getOriginalFilename());
					model.addAttribute("ideaRm", new IdeaRm());
					model.addAttribute("usr", user);
					model.addAttribute("cat_list", tagService.getAll());
					model.addAttribute("ok", "false");
					model.addAttribute("msg", "Sorry, Unknown file type found.");
					return "/idea/add";
				}
				Attachment attachment = new Attachment();
				Long attachmentId = System.currentTimeMillis();
				//attachment.setId(attachmentId);
				attachment.setFileName("" + attachmentId);
				attachment.setFileTitle(ideaRm.getIdeaTitle());
				attachment = attachmentService.save(attachment, file, user.getId());
				attachments.add(attachment);
			}

		}

		ideaDto.setAttachments(attachments);
		BeanUtils.copyProperties(ideaDto, ideaEntity);
		ideaEntity.setEntryDate(entry_date);
		ideaEntity.setIsDelete(true);
		ideaEntity.setAuthorEmail(user.getEmail());
		ideaEntity.setCountViews(0);
		ideaEntity.setUserId(user);
		ideaService.add(ideaEntity);
		return "redirect:/idea/show-all";
	}

	@GetMapping("/idea/show-all")
	public String show_all(Model model, Authentication authentication) {
		var userName = authentication.getName();
		org.springframework.security.core.userdetails.User authenticateduser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		com.ewsd.model.User user = userService.getUserByName(authenticateduser.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("username", userName);
		// model.addAttribute("deptName",);
		model.addAttribute("idea", new IdeaRm());
		model.addAttribute("idea_list", ideaService.getAll());
		model.addAttribute("message", "Showing All Ideas");
		return "idea/show-all";
	}
	/*
	 * 3rd : [ Attachment [ id=1587165431890, fileName=1587165431890, fileTitle=test
	 * A, fileURL=/uploaded_img/11587165431890.png, fileType=image/png ], Attachment
	 * [ id=1587165431806, fileName=1587165431806, fileTitle=test A,
	 * fileURL=/uploaded_img/11587165431806.png, fileType=image/png ], Attachment [
	 * id=1587165431902, fileName=1587165431902, fileTitle=test A,
	 * fileURL=/uploaded_img/11587165431902.jpg, fileType=image/jpeg ] ] [Attachment
	 * [ id=1587165431890, fileName=1587165431890, fileTitle=test A,
	 * fileURL=/uploaded_img/11587165431890.png, fileType=image/png ], Attachment
	 * [id=1587165431806, fileName=1587165431806, fileTitle=test A,
	 * fileURL=/uploaded_img/11587165431806.png, fileType=image/png], Attachment
	 * [id=1587165431902, fileName=1587165431902, fileTitle=test A,
	 * fileURL=/uploaded_img/11587165431902.jpg, fileType=image/jpeg]]
	 */
}
