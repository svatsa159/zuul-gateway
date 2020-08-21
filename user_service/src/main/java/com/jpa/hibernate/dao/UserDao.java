package com.jpa.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	public User findByUserId(String userId);
}
