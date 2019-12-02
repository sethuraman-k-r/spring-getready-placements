package com.spring.getready.template.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileTemplate {

	private String about;
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private Character gender;
	private String hometown;
	private String religion;
	private MultipartFile profile;

}
