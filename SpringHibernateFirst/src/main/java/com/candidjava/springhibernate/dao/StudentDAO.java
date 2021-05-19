package com.candidjava.springhibernate.dao;

import java.util.List;

import com.candidjava.springhibernate.model.Student;

public interface StudentDAO {
	public void saveStudent(Student student);
	public List<Student> getStudents();
}
