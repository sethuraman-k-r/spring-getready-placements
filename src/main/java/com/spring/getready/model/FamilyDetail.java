package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the family_details database table.
 * 
 */
@Entity
@Table(name="family_details")
@NamedQuery(name="FamilyDetail.findAll", query="SELECT f FROM FamilyDetail f")
public class FamilyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="family_id")
	private Integer familyId;

	@Column(name="father_name")
	private String fatherName;

	@Column(name="father_occupation")
	private String fatherOccupation;

	@Column(name="mother_name")
	private String motherName;

	@Column(name="mother_occupation")
	private String motherOccupation;

	//bi-directional many-to-one association to SiblingsDetail
	@OneToMany(mappedBy="familyDetail")
	private List<SiblingsDetail> siblingsDetails;

	//bi-directional one-to-one association to UserDetail
	@OneToOne(mappedBy="familyDetail")
	private UserDetail userDetail;

	public FamilyDetail() {
	}

	public Integer getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherOccupation() {
		return this.fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherOccupation() {
		return this.motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public List<SiblingsDetail> getSiblingsDetails() {
		return this.siblingsDetails;
	}

	public void setSiblingsDetails(List<SiblingsDetail> siblingsDetails) {
		this.siblingsDetails = siblingsDetails;
	}

	public SiblingsDetail addSiblingsDetail(SiblingsDetail siblingsDetail) {
		getSiblingsDetails().add(siblingsDetail);
		siblingsDetail.setFamilyDetail(this);

		return siblingsDetail;
	}

	public SiblingsDetail removeSiblingsDetail(SiblingsDetail siblingsDetail) {
		getSiblingsDetails().remove(siblingsDetail);
		siblingsDetail.setFamilyDetail(null);

		return siblingsDetail;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}