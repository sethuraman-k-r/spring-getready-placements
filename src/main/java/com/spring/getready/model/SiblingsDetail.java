package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the siblings_details database table.
 * 
 */
@Entity
@Table(name="siblings_details")
@NamedQuery(name="SiblingsDetail.findAll", query="SELECT s FROM SiblingsDetail s")
public class SiblingsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sibling_id")
	private Integer siblingId;

	@Column(name="sibling_name")
	private String siblingName;

	@Column(name="sibling_occupation")
	private String siblingOccupation;

	//bi-directional many-to-one association to FamilyDetail
	@ManyToOne
	@JoinColumn(name="family_id")
	private FamilyDetail familyDetail;

	public SiblingsDetail() {
	}

	public Integer getSiblingId() {
		return this.siblingId;
	}

	public void setSiblingId(Integer siblingId) {
		this.siblingId = siblingId;
	}

	public String getSiblingName() {
		return this.siblingName;
	}

	public void setSiblingName(String siblingName) {
		this.siblingName = siblingName;
	}

	public String getSiblingOccupation() {
		return this.siblingOccupation;
	}

	public void setSiblingOccupation(String siblingOccupation) {
		this.siblingOccupation = siblingOccupation;
	}

	public FamilyDetail getFamilyDetail() {
		return this.familyDetail;
	}

	public void setFamilyDetail(FamilyDetail familyDetail) {
		this.familyDetail = familyDetail;
	}

}