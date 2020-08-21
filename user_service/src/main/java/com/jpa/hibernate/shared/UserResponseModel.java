package com.jpa.hibernate.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModel {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;

}
