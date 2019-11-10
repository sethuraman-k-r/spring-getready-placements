package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the academic_details database table.
 * 
 */
@Entity
@Table(name="academic_details")
@NamedQuery(name="AcademicDetail.findAll", query="SELECT a FROM AcademicDetail a")
public class AcademicDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="academic_id")
	private Integer academicId;

	@Column(name="academic_name")
	private String academicName;

	private String description;

	@Column(name="end_year")
	private Integer endYear;

	@Column(name="start_year")
	private Integer startYear;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_ref")
	private UserDetail userDetail;

	public AcademicDetail() {
	}

	public Integer getAcademicId() {
		return this.academicId;
	}

	public void setAcademicId(Integer academicId) {
		this.academicId = academicId;
	}

	public String getAcademicName() {
		return this.academicName;
	}

	public void setAcademicName(String academicName) {
		this.academicName = academicName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEndYear() {
		return this.endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public Integer getStartYear() {
		return this.startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}