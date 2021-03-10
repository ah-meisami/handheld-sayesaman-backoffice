package org.sunich.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunich.dao.BuyTypeDAO;
import org.sunich.model.BuyType;

import java.util.List;

@Repository
public class BuyTypeDAOImpl implements BuyTypeDAO {

    @Autowired
    private SessionFactory sessionFactory1;

    @Override
    public void insertBuyType(BuyType buyType) {
        sessionFactory1.getCurrentSession().save(buyType);
    }

    @Override
    public BuyType getBuyTypeById(int buyTypeId) {
        return (BuyType) sessionFactory1.getCurrentSession().get(BuyType.class, buyTypeId);
    }

    @Override
    public BuyType getBuyType(String buyTypename) {
        Query query = sessionFactory1.getCurrentSession().createQuery("from BuyType where name = :buyTypename");
        query.setParameter("buyTypename", buyTypename);
        return (BuyType) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BuyType> getBuyTypes() {
        Criteria criteria = sessionFactory1.getCurrentSession().createCriteria(BuyType.class);
        return criteria.list();
    }

}
