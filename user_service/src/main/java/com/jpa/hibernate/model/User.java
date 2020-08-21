package com.jpa.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "first_name")
	private String firstName;

	@Override
	public String toString() {
		return "User [Id=" + Id + ", userId=" + userId + ", firstName=" + firstName + ", password=" + password
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

	@Column(name = "password")
	private String password;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;

}
