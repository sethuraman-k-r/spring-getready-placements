package com.spring.getready.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_group database table.
 * 
 */
@Entity
@Table(name="user_group")
@NamedQuery(name="UserGroup.findAll", query="SELECT u FROM UserGroup u")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id")
	private Integer groupId;

	@Column(name="group_name")
	private String groupName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="short_group")
	private String shortGroup;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="userGroup")
	private List<UserDetail> userDetails;

	public UserGroup() {
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getShortGroup() {
		return this.shortGroup;
	}

	public void setShortGroup(String shortGroup) {
		this.shortGroup = shortGroup;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setUserGroup(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setUserGroup(null);

		return userDetail;
	}

}