package com.autowire.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autowire.bean.Student;
import com.autowire.repository.AutowireRepository;
import com.autowire.repository.CustomRepository;

@Service
public class AutowireServiceImpl implements AutowireService{
	@Autowired
	AutowireRepository autowireRepository;
	
	@Autowired
	CustomRepository customRepository;

	
	public List<Student> findStudents() {
		List<Student> list = autowireRepository.findAll();
		System.out.println("************** "+list);
		return list;
	}
	
	public Student insertStudent(Student stud) {
		//same as autowireRepository.save(stud)of CrudRepository
		return autowireRepository.insert(stud);
	}

	public Student findByRollNo(int roll) {
		Student stud = autowireRepository.findByRollNo(roll);
		if(stud == null)
			throw new NullPointerException();
		else return stud;
	}

	public List<Student> findScienceStudents() {
		return autowireRepository.findScienceStudents();
	}


	public List<Student> findByAgeAndSection(int age, String section) {
		return autowireRepository.findByAgeAndSection(age, section);
	}

	public void updateStudentSection(int age, String section) {
		customRepository.updateStudentSection(age, section);
	}
}
