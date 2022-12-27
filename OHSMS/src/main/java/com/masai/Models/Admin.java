package com.masai.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	@Id
	@Column(name = "admin_Id")
	private Integer Id;

	private String firstName;

	private String LastName;

	private String username;

	private String password;

}
