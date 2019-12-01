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
import com.spring.getready.services.AssignmentService;
import com.spring.getready.services.SubmissionService;
import com.spring.getready.services.UploadFileService;

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

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView redirectToHome(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:/home/assignment");
		return modelAndView;
	}

	@RequestMapping(path = "/home/{page}", method = RequestMethod.GET)
	public String getHome(@PathVariable(name = "page", required = false) String page, Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetail userDetail = userDetailRepository.findByEmailEquals(username);
		model.addAttribute("username", userDetail.getUsername());
		if (page.contentEquals("assignment")) {
			model.addAttribute("assignment", assignmentService.checkPendingAssignment(userDetail.getUserUuid()));
		}
		return "home";
	}

	@RequestMapping(path = "/home/upload/submission", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("file") MultipartFile file,
			@RequestParam("assignmentId") Integer assignmentId, ModelAndView modelView,
			RedirectAttributes redirectAttributes) throws FileException {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetail userDetail = userDetailRepository.findByEmailEquals(username);
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

}
