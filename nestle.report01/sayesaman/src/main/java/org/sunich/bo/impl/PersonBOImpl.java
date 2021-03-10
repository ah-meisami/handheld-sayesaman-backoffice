package org.sunich.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunich.bo.PersonBO;
import org.sunich.dao.PersonDAO;
import org.sunich.model.Person;

import java.util.List;

@Service
public class PersonBOImpl implements PersonBO {

    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional(value = "transactionManager1")
    public void insertPerson(Person person) {
        personDAO.insertPerson(person);
    }

    @Override
    @Transactional(value = "transactionManager1")
    public Person getPersonById(int personId) {
        return personDAO.getPersonById(personId);
    }

    @Override
    @Transactional(value = "transactionManager1")
    public Person getPerson(String personname) {
        return personDAO.getPerson(personname);
    }

    @Override
    @Transactional(value = "transactionManager1")
    public List<Person> getPersons() {
        return personDAO.getPersons();
    }

    @Override
    @Transactional(value = "transactionManager1")
    public List<Person> getPersonsBySP(long personnelRef, long supervisorRef, long dCRef, long personnelTypeRef) {
        return personDAO.getPersonsBySP(personnelRef, supervisorRef, dCRef, personnelTypeRef);
    }

}