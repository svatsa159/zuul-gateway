package com.jpa.hibernate.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.hibernate.exceptions.UserNotFoundException;
import com.jpa.hibernate.model.User;
import com.jpa.hibernate.service.UserService;
import com.jpa.hibernate.shared.UserRequestModel;
import com.jpa.hibernate.shared.UserResponseModel;

@RestController
@RequestMapping("/api")
public class UserController {
	private UserService userService;
	private ModelMapper mapper;

	public UserController(UserService userService, ModelMapper mapper) {
		super();
		this.userService = userService;
		this.mapper = mapper;
	}

	@PostMapping("/users/add")
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {
		return new ResponseEntity<UserResponseModel>(userService.createNewUser(userRequestModel), HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserResponseModel>> getAllUsers() {
		return new ResponseEntity<List<UserResponseModel>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable("userId") String userId)
			throws UserNotFoundException {
		User user = userService.findUserById(userId);
		if (user == null) {
			throw new UserNotFoundException("user not found with id " + userId);
		}
		return new ResponseEntity<UserResponseModel>(
				mapper.map(userService.findUserById(userId), UserResponseModel.class), HttpStatus.FOUND);
	}

}
