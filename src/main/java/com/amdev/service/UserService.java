package com.amdev.service;

import java.util.List;

import com.amdev.entity.User;

public interface UserService {
	public List<User> getUsers();

	public void saveUser(User user);
}
