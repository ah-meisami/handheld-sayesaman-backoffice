package org.sunich.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.sunich.dao.UserDAO;
import org.sunich.model.User;
import org.sunich.bo.UserBO;

@Service
public class UserBOImpl implements UserBO {

	@Autowired
	private UserDAO userDAO;
	
	@Override
    @Transactional(value = "transactionManager1")
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	@Override
    @Transactional(value = "transactionManager1")
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	@Override
    @Transactional(value = "transactionManager1")
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Override
    @Transactional(value = "transactionManager1")
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

}
