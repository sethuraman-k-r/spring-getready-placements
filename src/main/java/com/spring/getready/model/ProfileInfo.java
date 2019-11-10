package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the profile_info database table.
 * 
 */
@Entity
@Table(name="profile_info")
@NamedQuery(name="ProfileInfo.findAll", query="SELECT p FROM ProfileInfo p")
public class ProfileInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="profile_id")
	private Integer profileId;

	@Column(name="about_user")
	private String aboutUser;

	@Column(name="address_user")
	private String addressUser;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String gender;

	private String hometown;

	private String religion;

	//bi-directional many-to-one association to UploadFile
	@ManyToOne
	@JoinColumn(name="profile_picture")
	private UploadFile uploadFile;

	//bi-directional one-to-one association to UserDetail
	@OneToOne
	@JoinColumn(name="user_ref")
	private UserDetail userDetail;

	public ProfileInfo() {
	}

	public Integer getProfileId() {
		return this.profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getAboutUser() {
		return this.aboutUser;
	}

	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}

	public String getAddressUser() {
		return this.addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
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