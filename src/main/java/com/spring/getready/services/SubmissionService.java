package com.spring.getready.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.getready.model.AssignmentDetail;
import com.spring.getready.model.SubmissionDetail;
import com.spring.getready.model.UploadFile;
import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.AssignmentDetailRepository;
import com.spring.getready.repository.SubmissionDetailRepository;

@Service
public class SubmissionService {

	@Autowired
	private AssignmentDetailRepository assignmentDetailRepository;

	@Autowired
	private SubmissionDetailRepository submissionDetailRepository;

	public boolean uploadSubmission(Integer assignmentId, UploadFile uploadFile, UserDetail userDetail) {
		Optional<AssignmentDetail> assignmentDetail = assignmentDetailRepository.findById(assignmentId);
		SubmissionDetail submissionDetail = new SubmissionDetail();
		submissionDetail.setAssignmentDetail(assignmentDetail.get());
		submissionDetail.setUploadFile(uploadFile);
		submissionDetail.setUserDetail(userDetail);
		submissionDetail.setSubmittedOn(new Timestamp(new Date().getTime()));
		return submissionDetailRepository.save(submissionDetail) != null;
	}

}
