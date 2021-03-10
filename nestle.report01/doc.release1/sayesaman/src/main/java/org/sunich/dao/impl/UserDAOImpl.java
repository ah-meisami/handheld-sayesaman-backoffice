package org.sunich.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunich.dao.UserDAO;
import org.sunich.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory1;

    @Override
    public void insertUser(User user) {
        sessionFactory1.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(int userId) {
        return (User) sessionFactory1.getCurrentSession().get(User.class, userId);
    }

    @Override
    public User getUser(String username) {
        Query query = sessionFactory1.getCurrentSession().createQuery("from User where username = :username");
        query.setParameter("username", username);
        return (User) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Criteria criteria = sessionFactory1.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }

}
