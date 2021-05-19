package com.autowire.service;

import java.util.Collection;
import java.util.List;

import com.autowire.bean.Student;

public interface AutowireService {

	public List<Student> findStudents();
	public Student insertStudent(Student stud);
	public Student findByRollNo(int rollid);
	public List<Student> findByAgeAndSection(int age, String section);
	public List<Student> findScienceStudents();
	public void updateStudentSection(int age, String section);

}
