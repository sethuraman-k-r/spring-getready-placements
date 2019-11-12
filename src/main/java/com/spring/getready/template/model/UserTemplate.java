package com.spring.getready.template.model;

import lombok.Getter;

@Getter
public class UserTemplate {

	private String username;
	private String email;
	private int group;

	@Override
	public String toString() {
		return "UserTemplate [" + username + ", " + email + ", " + group + "]";
	}

}
