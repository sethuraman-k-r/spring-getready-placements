package com.spring.getready.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.getready.config.FilePropertyConfig;
import com.spring.getready.interceptor.FileException;
import com.spring.getready.model.UploadFile;
import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.UserDetailRepository;
import com.spring.getready.services.AcademicService;
import com.spring.getready.services.AssignmentService;
import com.spring.getready.services.ProfileService;
import com.spring.getready.services.RelationService;
import com.spring.getready.services.SubmissionService;
import com.spring.getready.services.UploadFileService;
import com.spring.getready.template.model.AcademicTemplate;
import com.spring.getready.template.model.ParentsTemplate;
import com.spring.getready.template.model.ProfileTemplate;

@Controller
public class HomeController {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Autowired
	private AssignmentService assignmentService;

	@Autowired
	private SubmissionService submissionService;

	@Autowired
	private FilePropertyConfig filePropertyConfig;

	@Autowired
	private UploadFileService uploadFileService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private AcademicService academicService;

	@Autowired
	private RelationService relationService;

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView redirectToHome(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:/home/assignment");
		return modelAndView;
	}

	@RequestMapping(path = "/home/{page}", method = RequestMethod.GET)
	public String getHome(@PathVariable(name = "page", required = false) String page, Model model) {
		UserDetail userDetail = getCurrentUser();
		model.addAttribute("username", userDetail.getUsername());
		if (page.contentEquals("assignment")) {
			model.addAttribute("assignment", assignmentService.checkPendingAssignment(userDetail.getUserUuid()));
		} else if (page.contentEquals("profile")) {
			model.addAttribute("profile", profileService.getProfileDetails(userDetail.getUserUuid()));
		} else if (page.contentEquals("academy")) {
			model.addAttribute("academy", academicService.getAcademicDetails(userDetail.getUserUuid()));
		} else if (page.contentEquals("family")) {
			model.addAttribute("family", relationService.getFamilyDetails(userDetail.getUserUuid()));
		}
		return "home";
	}

	@RequestMapping(path = "/home/upload/submission", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("file") MultipartFile file,
			@RequestParam("assignmentId") Integer assignmentId, ModelAndView modelView,
			RedirectAttributes redirectAttributes) throws FileException {
		UserDetail userDetail = getCurrentUser();
		if (file != null) {
			String fileName = new Date().getTime() + "_" + file.getOriginalFilename();
			Path path = Paths.get(new File(filePropertyConfig.getFilePath() + File.separator + fileName).toURI());
			try {
				Path outputPath = Files.write(path, file.getBytes());
				if (outputPath != null) {
					UploadFile uploadFile = uploadFileService.uploadFile(fileName, file.getOriginalFilename());
					boolean result = submissionService.uploadSubmission(assignmentId, uploadFile, userDetail);
					if (result) {
						redirectAttributes.addFlashAttribute("message", "Assignment uploaded successfully");
					}
					modelView.setViewName("redirect:/home/assignment");
				}
			} catch (IOException io) {
				throw new FileException("Error while submitting an assignment");
			}
		}
		return modelView;
	}

	@RequestMapping(path = "/home/update/{section}", method = RequestMethod.POST)
	public ModelAndView updateProfile(@PathVariable(name = "section", required = false) String section,
			@ModelAttribute ProfileTemplate profile, @ModelAttribute AcademicTemplate academy,
			@ModelAttribute("parents") ParentsTemplate parents, ModelAndView modelView, RedirectAttributes redirectAttributes) {
		UserDetail userDetail = getCurrentUser();
		if (section.contentEquals("profile")) {
			boolean result = profileService.updateProfile(profile, userDetail);
			if (result) {
				redirectAttributes.addFlashAttribute("message", "Profile updated successfully");
			}
			modelView.setViewName("redirect:/home/profile");
		} else if (section.contentEquals("academy")) {
			boolean result = academicService.addAcademicDetails(academy, userDetail.getUserUuid());
			if (result) {
				redirectAttributes.addFlashAttribute("message", "Academic details successfully added");
			}
			modelView.setViewName("redirect:/home/academy");
		} else if (section.contentEquals("family")) {
			boolean result = relationService.addFamilyDetails(parents, userDetail.getUserUuid());
			if (result) {
				redirectAttributes.addFlashAttribute("message", "Family details added successfully");
			}
			modelView.setViewName("redirect:/home/family");
		}
		return modelView;
	}

	@RequestMapping(path = "/home/delete/{section}", method = RequestMethod.POST)
	public ModelAndView deleteDetails(@PathVariable(name = "section", required = false) String section,
			@RequestParam(name = "academy_id", required = false) Integer academicId, ModelAndView modelView,
			RedirectAttributes redirectAttributes) {
		UserDetail userDetail = getCurrentUser();
		if (section.contentEquals("academy")) {
			boolean result = academicService.deleteAcademicDetails(academicId, userDetail.getUserUuid());
			if (result) {
				redirectAttributes.addFlashAttribute("message", "Academic details updated successfully");
			}
			modelView.setViewName("redirect:/home/academy");
		}
		return modelView;
	}

	public UserDetail getCurrentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetail userDetail = userDetailRepository.findByEmailEquals(username);
		return userDetail;
	}

}
