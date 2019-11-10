package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the submission_details database table.
 * 
 */
@Entity
@Table(name="submission_details")
@NamedQuery(name="SubmissionDetail.findAll", query="SELECT s FROM SubmissionDetail s")
public class SubmissionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="submission_id")
	private Integer submissionId;

	@Column(name="submitted_on")
	private Timestamp submittedOn;

	//bi-directional many-to-one association to AssignmentDetail
	@ManyToOne
	@JoinColumn(name="assignment_ref")
	private AssignmentDetail assignmentDetail;

	//bi-directional many-to-one association to UploadFile
	@ManyToOne
	@JoinColumn(name="submission_file_ref")
	private UploadFile uploadFile;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_ref")
	private UserDetail userDetail;

	public SubmissionDetail() {
	}

	public Integer getSubmissionId() {
		return this.submissionId;
	}

	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}

	public Timestamp getSubmittedOn() {
		return this.submittedOn;
	}

	public void setSubmittedOn(Timestamp submittedOn) {
		this.submittedOn = submittedOn;
	}

	public AssignmentDetail getAssignmentDetail() {
		return this.assignmentDetail;
	}

	public void setAssignmentDetail(AssignmentDetail assignmentDetail) {
		this.assignmentDetail = assignmentDetail;
	}

	public UploadFile getUploadFile() {
		return this.uploadFile;
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}