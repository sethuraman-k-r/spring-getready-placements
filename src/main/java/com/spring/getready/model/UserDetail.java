package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_details database table.
 * 
 */
@Entity
@Table(name="user_details")
@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;

	@Column(name="created_on")
	private Timestamp createdOn;

	private String email;

	@Column(name="is_locked")
	private Boolean isLocked;

	@Column(name="last_login_on")
	private Timestamp lastLoginOn;

	private String password;

	@Column(name="user_uuid")
	private String userUuid;

	private String username;

	//bi-directional many-to-one association to AcademicDetail
	@OneToMany(mappedBy="userDetail")
	private List<AcademicDetail> academicDetails;

	//bi-directional many-to-one association to AssignmentDetail
	@OneToMany(mappedBy="userDetail")
	private List<AssignmentDetail> assignmentDetails;

	//bi-directional many-to-one association to SubmissionDetail
	@OneToMany(mappedBy="userDetail")
	private List<SubmissionDetail> submissionDetails;

	//bi-directional many-to-one association to UserGroup
	@ManyToOne
	@JoinColumn(name="group_ref")
	private UserGroup userGroup;

	//bi-directional one-to-one association to FamilyDetail
	@OneToOne
	@JoinColumn(name="family_ref")
	private FamilyDetail familyDetail;

	//bi-directional one-to-one association to ProfileInfo
	@OneToOne(mappedBy="userDetail")
	private ProfileInfo profileInfo;

	public UserDetail() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Timestamp getLastLoginOn() {
		return this.lastLoginOn;
	}

	public void setLastLoginOn(Timestamp lastLoginOn) {
		this.lastLoginOn = lastLoginOn;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserUuid() {
		return this.userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AcademicDetail> getAcademicDetails() {
		return this.academicDetails;
	}

	public void setAcademicDetails(List<AcademicDetail> academicDetails) {
		this.academicDetails = academicDetails;
	}

	public AcademicDetail addAcademicDetail(AcademicDetail academicDetail) {
		getAcademicDetails().add(academicDetail);
		academicDetail.setUserDetail(this);

		return academicDetail;
	}

	public AcademicDetail removeAcademicDetail(AcademicDetail academicDetail) {
		getAcademicDetails().remove(academicDetail);
		academicDetail.setUserDetail(null);

		return academicDetail;
	}

	public List<AssignmentDetail> getAssignmentDetails() {
		return this.assignmentDetails;
	}

	public void setAssignmentDetails(List<AssignmentDetail> assignmentDetails) {
		this.assignmentDetails = assignmentDetails;
	}

	public AssignmentDetail addAssignmentDetail(AssignmentDetail assignmentDetail) {
		getAssignmentDetails().add(assignmentDetail);
		assignmentDetail.setUserDetail(this);

		return assignmentDetail;
	}

	public AssignmentDetail removeAssignmentDetail(AssignmentDetail assignmentDetail) {
		getAssignmentDetails().remove(assignmentDetail);
		assignmentDetail.setUserDetail(null);

		return assignmentDetail;
	}

	public List<SubmissionDetail> getSubmissionDetails() {
		return this.submissionDetails;
	}

	public void setSubmissionDetails(List<SubmissionDetail> submissionDetails) {
		this.submissionDetails = submissionDetails;
	}

	public SubmissionDetail addSubmissionDetail(SubmissionDetail submissionDetail) {
		getSubmissionDetails().add(submissionDetail);
		submissionDetail.setUserDetail(this);

		return submissionDetail;
	}

	public SubmissionDetail removeSubmissionDetail(SubmissionDetail submissionDetail) {
		getSubmissionDetails().remove(submissionDetail);
		submissionDetail.setUserDetail(null);

		return submissionDetail;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public FamilyDetail getFamilyDetail() {
		return this.familyDetail;
	}

	public void setFamilyDetail(FamilyDetail familyDetail) {
		this.familyDetail = familyDetail;
	}

	public ProfileInfo getProfileInfo() {
		return this.profileInfo;
	}

	public void setProfileInfo(ProfileInfo profileInfo) {
		this.profileInfo = profileInfo;
	}

}