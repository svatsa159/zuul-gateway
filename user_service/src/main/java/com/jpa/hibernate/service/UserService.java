package com.jpa.hibernate.service;

import java.util.List;

import com.jpa.hibernate.model.User;
import com.jpa.hibernate.shared.UserRequestModel;
import com.jpa.hibernate.shared.UserResponseModel;

public interface UserService {
	public UserResponseModel createNewUser(UserRequestModel userRequestModel);

	public List<UserResponseModel> getAllUsers();

	public User findUserById(String userId);
}
