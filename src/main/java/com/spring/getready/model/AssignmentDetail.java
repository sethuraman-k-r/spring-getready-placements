package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the assignment_details database table.
 * 
 */
@Entity
@Table(name="assignment_details")
@NamedQuery(name="AssignmentDetail.findAll", query="SELECT a FROM AssignmentDetail a")
public class AssignmentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assignment_id")
	private Integer assignmentId;

	@Column(name="assignment_description")
	private String assignmentDescription;

	@Column(name="assignment_name")
	private String assignmentName;

	@Column(name="created_on")
	private Timestamp createdOn;

	private Timestamp deadline;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	//bi-directional many-to-one association to CourseList
	@ManyToOne
	@JoinColumn(name="course_ref")
	private CourseList courseList;

	//bi-directional many-to-one association to UploadFile
	@ManyToOne
	@JoinColumn(name="reference_file_ref")
	private UploadFile uploadFile;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="created_by")
	private UserDetail userDetail;

	//bi-directional many-to-one association to SubmissionDetail
	@OneToMany(mappedBy="assignmentDetail")
	private List<SubmissionDetail> submissionDetails;

	public AssignmentDetail() {
	}

	public Integer getAssignmentId() {
		return this.assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentDescription() {
		return this.assignmentDescription;
	}

	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}

	public String getAssignmentName() {
		return this.assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public CourseList getCourseList() {
		return this.courseList;
	}

	public void setCourseList(CourseList courseList) {
		this.courseList = courseList;
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

	public List<SubmissionDetail> getSubmissionDetails() {
		return this.submissionDetails;
	}

	public void setSubmissionDetails(List<SubmissionDetail> submissionDetails) {
		this.submissionDetails = submissionDetails;
	}

	public SubmissionDetail addSubmissionDetail(SubmissionDetail submissionDetail) {
		getSubmissionDetails().add(submissionDetail);
		submissionDetail.setAssignmentDetail(this);

		return submissionDetail;
	}

	public SubmissionDetail removeSubmissionDetail(SubmissionDetail submissionDetail) {
		getSubmissionDetails().remove(submissionDetail);
		submissionDetail.setAssignmentDetail(null);

		return submissionDetail;
	}

}