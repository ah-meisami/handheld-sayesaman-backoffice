package org.sunich.dao;

import org.sunich.model.Person;

import java.util.List;

public interface PersonDAO {

	void insertPerson(Person person);
	
	Person getPersonById(int personId);
	
	Person getPerson(String personname);
	
    List<Person> getPersons();

    List<Person> getPersonsBySP(long personnelRef, long supervisorRef, long dCRef, long personnelTypeRef);
}
