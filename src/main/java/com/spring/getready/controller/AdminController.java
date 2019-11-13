package com.spring.getready.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
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
import com.spring.getready.model.StaffDetail;
import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.StaffDetailRepository;
import com.spring.getready.repository.UserDetailRepository;
import com.spring.getready.services.StaffService;
import com.spring.getready.services.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Autowired
	private StaffDetailRepository staffDetailRepository;

	@Autowired
	private FilePropertyConfig filePropertyConfig;

	@Autowired
	private UserService userService;

	@Autowired
	private StaffService staffService;

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public ModelAndView redirectAdminHome(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:/admin/users");
		return modelAndView;
	}

	@RequestMapping(path = "/admin/{page}", method = RequestMethod.GET)
	public String getAdminHome(@PathVariable("page") String page, Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetail userDetail = userDetailRepository.findByEmailEquals(username);
		model.addAttribute("username", userDetail.getUsername());
		if (page.contentEquals("users")) {
			List<UserDetail> userDetails = userDetailRepository.findByEmailNot("admin@spring.ats");
			model.addAttribute("users", userDetails);
		} else if (page.contentEquals("staff")) {
			List<StaffDetail> staffDetails = staffDetailRepository.findAll();
			model.addAttribute("staff", staffDetails);
		}
		return "admin";
	}

	@RequestMapping(path = "/admin/upload/users", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("users") MultipartFile file, ModelAndView modelView,
			RedirectAttributes redirectAttributes) throws FileException {
		if (file != null) {
			String fileName = new Date().getTime() + "_" + file.getOriginalFilename();
			Path path = Paths.get(new File(filePropertyConfig.getFilePath() + File.separator + fileName).toURI());
			try {
				Path outputPath = Files.write(path, file.getBytes());
				if (outputPath != null) {
					boolean result = userService.uploadUsers(path.toAbsolutePath().toString());
					if (result) {
						redirectAttributes.addFlashAttribute("message", "Users created successfully");
					}
					modelView.setViewName("redirect:/admin");
				}
			} catch (IOException io) {
				throw new FileException("Error while upload users");
			}
		}
		return modelView;
	}

	@RequestMapping(path = "/admin/user/reset", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("user") int userId, ModelAndView modelView) throws FileException {
		userService.resetUser(userId);
		modelView.setViewName("redirect:/admin");
		return modelView;
	}

	@RequestMapping(path = "/admin/staff/{operation}", method = RequestMethod.POST)
	public ModelAndView staffService(@RequestParam(name = "staffname", required = false) String name,
			@RequestParam(name = "field", required = false) String field,
			@RequestParam(name = "technology", required = false) String technology,
			@PathVariable("operation") String operation, ModelAndView modelView) throws FileException {
		if (operation.contentEquals("add")) {
			staffService.addNewStaff(name, field, technology);
		}
		modelView.setViewName("redirect:/admin/staff");
		return modelView;
	}

}
