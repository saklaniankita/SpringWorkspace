package com.autowire.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.autowire.bean.Student;

@Repository
public interface AutowireRepository extends MongoRepository<Student, String>{

	Student findByRollNo(int roll);
	
	List<Student> findByAgeAndSection(int age, String section);
	
	@Query("{'section' : 'Science'}")
	List<Student> findScienceStudents();
	
	

}
