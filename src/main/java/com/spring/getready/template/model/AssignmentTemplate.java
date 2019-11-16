package com.spring.getready.template.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentTemplate {
	
	private String name;
	private Integer course;
	private String description;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date deadline;
	
	private Integer creator;
	private MultipartFile reference;

}
