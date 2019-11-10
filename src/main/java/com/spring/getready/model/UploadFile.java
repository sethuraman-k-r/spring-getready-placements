package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the upload_files database table.
 * 
 */
@Entity
@Table(name="upload_files")
@NamedQuery(name="UploadFile.findAll", query="SELECT u FROM UploadFile u")
public class UploadFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="file_id")
	private Integer fileId;

	@Column(name="file_name")
	private String fileName;

	@Column(name="file_original_name")
	private String fileOriginalName;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="last_access_on")
	private Timestamp lastAccessOn;

	@Column(name="uploaded_on")
	private Timestamp uploadedOn;

	//bi-directional many-to-one association to AssignmentDetail
	@OneToMany(mappedBy="uploadFile")
	private List<AssignmentDetail> assignmentDetails;

	//bi-directional many-to-one association to ProfileInfo
	@OneToMany(mappedBy="uploadFile")
	private List<ProfileInfo> profileInfos;

	//bi-directional many-to-one association to SubmissionDetail
	@OneToMany(mappedBy="uploadFile")
	private List<SubmissionDetail> submissionDetails;

	public UploadFile() {
	}

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileOriginalName() {
		return this.fileOriginalName;
	}

	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Timestamp getLastAccessOn() {
		return this.lastAccessOn;
	}

	public void setLastAccessOn(Timestamp lastAccessOn) {
		this.lastAccessOn = lastAccessOn;
	}

	public Timestamp getUploadedOn() {
		return this.uploadedOn;
	}

	public void setUploadedOn(Timestamp uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public List<AssignmentDetail> getAssignmentDetails() {
		return this.assignmentDetails;
	}

	public void setAssignmentDetails(List<AssignmentDetail> assignmentDetails) {
		this.assignmentDetails = assignmentDetails;
	}

	public AssignmentDetail addAssignmentDetail(AssignmentDetail assignmentDetail) {
		getAssignmentDetails().add(assignmentDetail);
		assignmentDetail.setUploadFile(this);

		return assignmentDetail;
	}

	public AssignmentDetail removeAssignmentDetail(AssignmentDetail assignmentDetail) {
		getAssignmentDetails().remove(assignmentDetail);
		assignmentDetail.setUploadFile(null);

		return assignmentDetail;
	}

	public List<ProfileInfo> getProfileInfos() {
		return this.profileInfos;
	}

	public void setProfileInfos(List<ProfileInfo> profileInfos) {
		this.profileInfos = profileInfos;
	}

	public ProfileInfo addProfileInfo(ProfileInfo profileInfo) {
		getProfileInfos().add(profileInfo);
		profileInfo.setUploadFile(this);

		return profileInfo;
	}

	public ProfileInfo removeProfileInfo(ProfileInfo profileInfo) {
		getProfileInfos().remove(profileInfo);
		profileInfo.setUploadFile(null);

		return profileInfo;
	}

	public List<SubmissionDetail> getSubmissionDetails() {
		return this.submissionDetails;
	}

	public void setSubmissionDetails(List<SubmissionDetail> submissionDetails) {
		this.submissionDetails = submissionDetails;
	}

	public SubmissionDetail addSubmissionDetail(SubmissionDetail submissionDetail) {
		getSubmissionDetails().add(submissionDetail);
		submissionDetail.setUploadFile(this);

		return submissionDetail;
	}

	public SubmissionDetail removeSubmissionDetail(SubmissionDetail submissionDetail) {
		getSubmissionDetails().remove(submissionDetail);
		submissionDetail.setUploadFile(null);

		return submissionDetail;
	}

}