package com.demo.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = RoleTypeDeSerializer.class)
public enum Role {

	ADMIN("ADMIN"), 
	EMPLOYEE("EMPLOYEE"), 
	CUSTOMER("CUSTOMER");

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private Role(String role) {
		this.role = role;
	}

	public static Role getByName(String type) {
		for (Role typeEnum : values()) {
			if (typeEnum.getRole().equalsIgnoreCase(type)) {
				return typeEnum;
			}
		}
		throw new IllegalArgumentException(type + " is not a valid Role");
	}
}