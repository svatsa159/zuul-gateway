package com.jpa.hibernate.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserErrorResponse {
	private String errorMessage;
	private int statusCode;
	private long exceptionTime;

}
