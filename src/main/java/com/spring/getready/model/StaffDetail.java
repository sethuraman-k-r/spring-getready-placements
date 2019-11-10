package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the staff_details database table.
 * 
 */
@Entity
@Table(name="staff_details")
@NamedQuery(name="StaffDetail.findAll", query="SELECT s FROM StaffDetail s")
public class StaffDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="staff_id")
	private Integer staffId;

	private String field;

	@Column(name="staff_name")
	private String staffName;

	@Column(name="technology_known")
	private String technologyKnown;

	//bi-directional many-to-one association to CourseList
	@OneToMany(mappedBy="staffDetail")
	private List<CourseList> courseLists1;

	//bi-directional many-to-many association to CourseList
	@ManyToMany
	@JoinTable(
		name="course_staff_list"
		, joinColumns={
			@JoinColumn(name="staff_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="course_id")
			}
		)
	private List<CourseList> courseLists2;

	public StaffDetail() {
	}

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getTechnologyKnown() {
		return this.technologyKnown;
	}

	public void setTechnologyKnown(String technologyKnown) {
		this.technologyKnown = technologyKnown;
	}

	public List<CourseList> getCourseLists1() {
		return this.courseLists1;
	}

	public void setCourseLists1(List<CourseList> courseLists1) {
		this.courseLists1 = courseLists1;
	}

	public CourseList addCourseLists1(CourseList courseLists1) {
		getCourseLists1().add(courseLists1);
		courseLists1.setStaffDetail(this);

		return courseLists1;
	}

	public CourseList removeCourseLists1(CourseList courseLists1) {
		getCourseLists1().remove(courseLists1);
		courseLists1.setStaffDetail(null);

		return courseLists1;
	}

	public List<CourseList> getCourseLists2() {
		return this.courseLists2;
	}

	public void setCourseLists2(List<CourseList> courseLists2) {
		this.courseLists2 = courseLists2;
	}

}