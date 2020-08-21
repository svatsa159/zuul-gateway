package com.jpa.hibernate.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.dao.UserDao;
import com.jpa.hibernate.model.User;
import com.jpa.hibernate.shared.UserRequestModel;
import com.jpa.hibernate.shared.UserResponseModel;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private ModelMapper mapper;

	public UserServiceImpl(UserDao userDao, ModelMapper mapper) {
		super();
		this.userDao = userDao;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public UserResponseModel createNewUser(UserRequestModel userRequestModel) {
		userRequestModel.setUserId(UUID.randomUUID().toString());

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = userDao.save(mapper.map(userRequestModel, User.class));
		return mapper.map(user, UserResponseModel.class);
	}

	@Override
	public List<UserResponseModel> getAllUsers() {

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		List<UserResponseModel> userList = userDao.findAll().stream()
				.map(user -> mapper.map(user, UserResponseModel.class)).collect(Collectors.toList());
		return userList;

	}

	@Override
	public User findUserById(String userId) {
		User user = userDao.findByUserId(userId);

		return user;
	}

}
