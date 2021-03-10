package org.sunich.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunich.dao.AccYearDAO;
import org.sunich.model.AccYear;

import java.util.List;

@Repository
public class AccYearDAOImpl implements AccYearDAO {

    @Autowired
    private SessionFactory sessionFactory1;

    @Override
    @SuppressWarnings("unchecked")
    public List<AccYear> getAll() {
        Criteria criteria = sessionFactory1.getCurrentSession().createCriteria(AccYear.class);
        return criteria.list();
    }

}
