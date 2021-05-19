package com.candidjava.springhibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.candidjava.springhibernate.model.Student;

public class StudentDAOImpl implements StudentDAO{
	SessionFactory sessionFactory;
	Session session;
	Session getSession() {
		Configuration config = new Configuration();
        sessionFactory = config.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
	}
	public void saveStudent(Student student) {
		session = getSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	public List<Student> getStudents() {
		session = getSession();
		@SuppressWarnings("deprecation")
		Criteria crit = session.createCriteria(Student.class);
		List<Student> results = crit.list();
		System.out.println(results);
		return results;
	}

}
