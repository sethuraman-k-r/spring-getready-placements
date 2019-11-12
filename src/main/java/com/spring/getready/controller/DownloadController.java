package com.spring.getready.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

	@Autowired
	ResourceLoader resourceLoader;

	@RequestMapping(path = "/download/{file}", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@PathVariable String file, HttpServletRequest request) {
		Resource resource = null;
		String users_template = null;

		try {
			if (file.contentEquals("users")) {
				resource = resourceLoader.getResource("classpath:format/user_template.json");
				users_template = new String(resource.getInputStream().readAllBytes());
			}
		} catch (IOException ex) {
			System.out.println("Could not determine file type.");
		}

		if (resource == null) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
					.body("{\"message\" : \"Request error\"}");
		} else {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
					.body(users_template);
		}
	}

}
