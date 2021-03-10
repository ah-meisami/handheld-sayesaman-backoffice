package org.sunich.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunich.dao.BankDAO;
import org.sunich.model.Bank;

import java.util.List;

@Repository
public class BankDAOImpl implements BankDAO {

    @Autowired
    private SessionFactory sessionFactory1;

    @Override
    public void insertBank(Bank bank) {
        sessionFactory1.getCurrentSession().save(bank);
    }

    @Override
    public void updateBank(Bank bank) {
        sessionFactory1.getCurrentSession().update(bank);
    }

    @Override
    public Bank getBankById(long bankId) {
        return (Bank) sessionFactory1.getCurrentSession().get(Bank.class, bankId);
    }

    @Override
    public void deleteBank(long bankId) {
        Bank bank = new Bank();
        bank = getBankById(bankId);
        sessionFactory1.getCurrentSession().delete(bank);
    }

    @Override
    public Bank getBank(String bankname) {
        Query query = sessionFactory1.getCurrentSession().createQuery("from Bank where name = :bankname");
        query.setParameter("bankname", bankname);
        return (Bank) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bank> getBanks() {
        Criteria criteria = sessionFactory1.getCurrentSession().createCriteria(Bank.class);
        return criteria.list();
    }

}
