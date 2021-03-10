package org.sunich.dao;

import java.util.List;

import org.sunich.model.User;

public interface UserDAO {

	void insertUser(User user);
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();
}
