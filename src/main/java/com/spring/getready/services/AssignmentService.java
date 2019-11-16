package com.spring.getready.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.getready.config.FilePropertyConfig;
import com.spring.getready.interceptor.FileException;
import com.spring.getready.model.AssignmentDetail;
import com.spring.getready.model.CourseList;
import com.spring.getready.model.StaffDetail;
import com.spring.getready.model.UploadFile;
import com.spring.getready.repository.AssignmentDetailRepository;
import com.spring.getready.repository.CourseListRepository;
import com.spring.getready.repository.StaffDetailRepository;
import com.spring.getready.repository.UploadFileRepository;
import com.spring.getready.template.model.AssignmentTemplate;

@Service
public class AssignmentService {

	@Autowired
	private FilePropertyConfig filePropertyConfig;
	
	@Autowired
	private CourseListRepository courseListRepository;

	@Autowired
	private AssignmentDetailRepository assignmentDetailRepository;

	@Autowired
	private UploadFileRepository uploadFileRepository;

	public boolean createAssignment(AssignmentTemplate assignment) throws FileException {
		boolean result = false;
		Date date = new Date();
		UploadFile referenceFile = null;
		Optional<CourseList> courseRef = null;
		if (assignment.getReference() != null) {
			String fileName = new Date().getTime() + "_" + assignment.getReference().getOriginalFilename();
			Path path = Paths.get(new File(filePropertyConfig.getFilePath() + File.separator + fileName).toURI());
			try {
				Path outputPath = Files.write(path, assignment.getReference().getBytes());
				if (outputPath != null) {
					UploadFile uploadFile = new UploadFile();
					uploadFile.setFileName(fileName);
					uploadFile.setFileOriginalName(assignment.getReference().getOriginalFilename());
					uploadFile.setUploadedOn(new Timestamp(new Date().getTime()));
					uploadFile.setIsDeleted(false);
					referenceFile = uploadFileRepository.save(uploadFile);
				}
			} catch (IOException io) {
				throw new FileException("Error while creating assignments");
			}
		}

		courseRef = courseListRepository.findById(assignment.getCourse());

		AssignmentDetail assignmentDetail = new AssignmentDetail();
		assignmentDetail.setAssignmentName(assignment.getName());
		assignmentDetail.setAssignmentDescription(assignment.getDescription());
		assignmentDetail.setCourseList(courseRef.isPresent() ? courseRef.get() : null);
		assignmentDetail.setDeadline(new Timestamp(assignment.getDeadline().getTime()));
		assignmentDetail.setIsDeleted(false);
		assignmentDetail.setCreatedOn(new Timestamp(date.getTime()));
		assignmentDetail.setUserDetail(null);
		assignmentDetail.setUploadFile(referenceFile);
		result = assignmentDetailRepository.save(assignmentDetail) != null;

		return result;
	}

}
