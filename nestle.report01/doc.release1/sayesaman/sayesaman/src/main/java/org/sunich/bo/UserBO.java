package org.sunich.bo;

import java.util.List;

import org.sunich.model.User;

public interface UserBO {

	void insertUser(User user);
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();
}
