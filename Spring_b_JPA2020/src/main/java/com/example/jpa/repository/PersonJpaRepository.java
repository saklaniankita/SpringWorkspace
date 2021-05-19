package com.example.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Person;


/**
 * 
 * @author ankitasaklani
 *
 */
@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	//If you provide an Id in the arguments => If ID already exists, it will update the record OR if there is no such id, it will insert a new 
	//                                         record with an id generated by Hibernate, completely ignoring the id provided by developer in 
   //										   the arguments
	
    //If id is not provided in the arguments => it will insert a new record with a new id generated by Hibernate
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList(); 
	}
}
