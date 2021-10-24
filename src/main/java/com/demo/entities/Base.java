package com.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@MappedSuperclass
@JsonInclude(Include.NON_EMPTY)
public class Base {

	@Column(name = "is_active")
	// @JsonProperty(access = Access.READ_ONLY)
	private Boolean isActive = true;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_on")
	private Long createdOn = getNowInMiliseconds();

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_on")
	private Long modifiedOn;

	public static Long getNowInMiliseconds() {
		Date now = new Date();
		return now.getTime();
	}
}
