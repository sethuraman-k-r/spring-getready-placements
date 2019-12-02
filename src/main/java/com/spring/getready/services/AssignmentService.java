package com.spring.getready.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.getready.config.FilePropertyConfig;
import com.spring.getready.interceptor.FileException;
import com.spring.getready.model.AssignmentDetail;
import com.spring.getready.model.CourseList;
import com.spring.getready.model.ProfileInfo;
import com.spring.getready.model.StaffDetail;
import com.spring.getready.model.SubmissionDetail;
import com.spring.getready.model.UploadFile;
import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.AssignmentDetailRepository;
import com.spring.getready.repository.CourseListRepository;
import com.spring.getready.repository.ProfileInfoRepository;
import com.spring.getready.repository.StaffDetailRepository;
import com.spring.getready.repository.SubmissionDetailRepository;
import com.spring.getready.repository.UploadFileRepository;
import com.spring.getready.repository.UserDetailRepository;
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

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Autowired
	private SubmissionDetailRepository submissionDetailRepository;

	@Autowired
	private ProfileInfoRepository profileInfoRepository;

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

	public Map<String, Object> checkPendingAssignment(String uuid) {
		Map<String, Object> assignmentInfo = new HashMap<String, Object>();
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			List<SubmissionDetail> submissionDetails = submissionDetailRepository.findByUserDetailEquals(userDetail);
			assignmentInfo.put("submissions", submissionDetails);
			if (submissionDetails.size() > 0) {
				List<AssignmentDetail> assignments = new ArrayList<AssignmentDetail>();
				for (SubmissionDetail submissionDetail : submissionDetails) {
					assignments.add(submissionDetail.getAssignmentDetail());
				}
				List<AssignmentDetail> assignmentDetails = assignmentDetailRepository
						.findNonSubmittedAssignments(assignments);
				assignmentInfo.put("assignments", assignmentDetails);
			} else {
				List<AssignmentDetail> assignmentDetails = assignmentDetailRepository.findByIsDeletedFalse();
				assignmentInfo.put("assignments", assignmentDetails);
			}
		}
		return assignmentInfo;
	}

	public ProfileInfo getProfileDetails(String uuid) {
		ProfileInfo profileInfo = null;
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			profileInfo = profileInfoRepository.findByUserDetailEquals(userDetail);
			if (profileInfo == null) {
				profileInfo = new ProfileInfo();
				profileInfo.setAboutUser("Describe yourself");
				profileInfo.setAddressUser("Address here");
				profileInfo.setDateOfBirth(new Date(1991, 1, 01));
				profileInfo.setGender("M");
				profileInfo.setHometown("Chennai");
				profileInfo.setReligion("Hindu");
				profileInfo.setUploadFile(null);
				profileInfo.setUserDetail(userDetail);
				profileInfoRepository.save(profileInfo);
			}
		}
		return profileInfo;
	}

}
