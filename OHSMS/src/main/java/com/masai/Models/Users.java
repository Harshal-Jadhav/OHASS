package com.masai.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.masai.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id")
	private Integer Id;

	private String firstName;

	private String LastName;

	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;
}
