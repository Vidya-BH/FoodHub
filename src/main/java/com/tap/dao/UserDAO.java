package com.tap.dao;

import java.util.List;
import com.tap.model.User;

public interface UserDAO {

	int addUser(User user);

	int updateUser(User user);

	int deleteUser(int userId);

	User getUserById(int userId);

	User getUserByEmail(String email);

	List<User> getAllUsers();

}