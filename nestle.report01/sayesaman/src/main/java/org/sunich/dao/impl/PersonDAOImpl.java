package org.sunich.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunich.dao.PersonDAO;
import org.sunich.model.Person;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory1;

    @Override
    public void insertPerson(Person person) {
        sessionFactory1.getCurrentSession().save(person);
    }

    @Override
    public Person getPersonById(int personId) {
        return (Person) sessionFactory1.getCurrentSession().get(Person.class, personId);
    }

    @Override
    public Person getPerson(String personname) {
        Query query = sessionFactory1.getCurrentSession().createQuery("from Person where name = :personname");
        query.setParameter("personname", personname);
        return (Person) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPersons() {
        Criteria criteria = sessionFactory1.getCurrentSession().createCriteria(Person.class);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPersonsBySP(long personnelRef, long supervisorRef, long dCRef, long personnelTypeRef) {
        Query exQuery = sessionFactory1.getCurrentSession().createSQLQuery("{ call gettblPersonnel(:personnelRef,:supervisorRef,:dCRef,:personnelTypeRef) }");
        exQuery.setLong("personnelRef", personnelRef);
        exQuery.setLong("supervisorRef", supervisorRef);
        exQuery.setLong("dCRef", dCRef);
        exQuery.setLong("personnelTypeRef", personnelTypeRef);

        return exQuery.list();
    }

}
