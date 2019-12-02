package com.spring.getready.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.getready.config.FilePropertyConfig;
import com.spring.getready.model.UploadFile;
import com.spring.getready.repository.UploadFileRepository;

@RestController
public class DownloadController {

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	private UploadFileRepository uploadFileRepository;

	@Autowired
	private FilePropertyConfig filePropertyConfig;

	@RequestMapping(path = "/download/{file}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFile(@PathVariable String file,
			@RequestParam(name = "id", required = false) Integer id, HttpServletRequest request)
			throws FileNotFoundException, IOException {
		ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
		Resource resource = null;
		String originalFileName = null;
		InputStreamResource streamResource = null;

		try {
			if (file.contentEquals("users")) {
				resource = resourceLoader.getResource("classpath:format/user_template.json");
				originalFileName = resource.getFilename();
				streamResource = new InputStreamResource(new FileInputStream(resource.getFile()));
			}
			if (file.contentEquals("attachment")) {
				Optional<UploadFile> referenceFile = uploadFileRepository.findById(id);
				if (referenceFile.isPresent()) {
					File downloadFile = new File(
							filePropertyConfig.getFilePath() + File.separator + referenceFile.get().getFileName());
					originalFileName = referenceFile.get().getFileOriginalName();
					streamResource = new InputStreamResource(new FileInputStream(downloadFile));
				}
			}
		} catch (IOException ex) {
			System.out.println("Could not determine file type.");
		}

		if (streamResource == null) {
			String errorResponse = new String("{\"message\" : \"Request error\"}");
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(errorResponse.getBytes());
		} else {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + originalFileName + "\"")
					.body(streamResource.getInputStream().readAllBytes());
		}
	}

}
