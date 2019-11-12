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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.getready.config.FilePropertyConfig;
import com.spring.getready.interceptor.FileException;
import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.UserDetailRepository;
import com.spring.getready.services.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Autowired
	private FilePropertyConfig filePropertyConfig;

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public String getAdminHome(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetail userDetail = userDetailRepository.findByEmailEquals(username);
		List<UserDetail> userDetails = userDetailRepository.findAll();
		model.addAttribute("username", userDetail.getUsername());
		model.addAttribute("users", userDetails);
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

}
