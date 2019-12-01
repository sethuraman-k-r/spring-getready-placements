package com.spring.getready.services;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.getready.model.UploadFile;
import com.spring.getready.repository.UploadFileRepository;

@Service
public class UploadFileService {

	@Autowired
	private UploadFileRepository uploadFileRepository;

	public UploadFile uploadFile(String fileName, String fileOriginalName) {
		UploadFile file = null;
		UploadFile uploadFile = new UploadFile();
		uploadFile.setFileName(fileName);
		uploadFile.setFileOriginalName(fileOriginalName);
		uploadFile.setIsDeleted(false);
		uploadFile.setUploadedOn(new Timestamp(new Date().getTime()));
		file = uploadFileRepository.save(uploadFile);
		return file;
	}

}
