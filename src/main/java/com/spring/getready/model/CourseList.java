package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course_list database table.
 * 
 */
@Entity
@Table(name="course_list")
@NamedQuery(name="CourseList.findAll", query="SELECT c FROM CourseList c")
public class CourseList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private Integer courseId;

	@Column(name="course_field")
	private String courseField;

	@Column(name="course_name")
	private String courseName;

	//bi-directional many-to-one association to AssignmentDetail
	@OneToMany(mappedBy="courseList")
	private List<AssignmentDetail> assignmentDetails;

	//bi-directional many-to-one association to StaffDetail
	@ManyToOne
	@JoinColumn(name="primary_staff")
	private StaffDetail staffDetail;

	//bi-directional many-to-many association to StaffDetail
	@ManyToMany(mappedBy="courseLists2")
	private List<StaffDetail> staffDetails;

	public CourseList() {
	}

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseField() {
		return this.courseField;
	}

	public void setCourseField(String courseField) {
		this.courseField = courseField;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<AssignmentDetail> getAssignmentDetails() {
		return this.assignmentDetails;
	}

	public void setAssignmentDetails(List<AssignmentDetail> assignmentDetails) {
		this.assignmentDetails = assignmentDetails;
	}

	public AssignmentDetail addAssignmentDetail(AssignmentDetail assignmentDetail) {
		getAssignmentDetails().add(assignmentDetail);
		assignmentDetail.setCourseList(this);

		return assignmentDetail;
	}

	public AssignmentDetail removeAssignmentDetail(AssignmentDetail assignmentDetail) {
		getAssignmentDetails().remove(assignmentDetail);
		assignmentDetail.setCourseList(null);

		return assignmentDetail;
	}

	public StaffDetail getStaffDetail() {
		return this.staffDetail;
	}

	public void setStaffDetail(StaffDetail staffDetail) {
		this.staffDetail = staffDetail;
	}

	public List<StaffDetail> getStaffDetails() {
		return this.staffDetails;
	}

	public void setStaffDetails(List<StaffDetail> staffDetails) {
		this.staffDetails = staffDetails;
	}

}