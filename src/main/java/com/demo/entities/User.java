package com.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
@DynamicUpdate
@DynamicInsert
@JsonInclude(Include.NON_EMPTY)
@TypeDef(name = "role", typeClass = EnumTypeConverter.class)
public class User extends Base {

	 	@Id
	    @SequenceGenerator(name = "users_seq", sequenceName = "users_id_seq", allocationSize = 1)
	    @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)
	   // @JsonProperty(access = Access.READ_ONLY)
	    @Column(name="id")
	    private Integer userId;

	    @NotBlank
	    @Size(max = 50)
	    @Column(name="first_name", nullable=false)
	    private String firstName;

	    @NotBlank
	    @Column(name="last_name")
	    @Size(max=50)
	    private String lastName;
	    
	    @Formula("(concat(trim(first_name), ' ',trim(last_name)))")
	    private String fullName;
	    
	    @Size(max = 50)
	    @Column(name = "username")
	    private String userName;

	    @NotBlank
	    @Email
	    @Column(name="email")
	    private String email;

	    @Column(name="mobile")
	    private String mobile;
	    
	    @Column(name = "land_line")
	    private String landLine;

	    @JsonIgnore
	    @Column(name="encrypted_password")
	    private String password;
	    
	    @Size(max = 256)
	    @Column(name = "job_title")
	    private String jobTitle;
	    
	    @Column(name="address1")
	    private String address1;

	    @Column(name="address2")
	    private String address2;

	    @Column(name="city")
	    private String city;

	    @Column(name="state")
	    private String state;
	    
	    @Column(name="pin_code")
	    private String pinCode;
	    
	    @Column(name = "role")
	    @Type(type = "role")
	    @Enumerated(EnumType.STRING)
	    private Role role;
	    
	    @Transient
	    private String roleName;
	    
	    @Size(max = 256)
	    @Column(name = "department")
	    private String department;
	    
}
