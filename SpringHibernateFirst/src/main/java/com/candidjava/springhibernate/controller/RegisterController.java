package com.candidjava.springhibernate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.candidjava.springhibernate.dao.StudentDAOImpl;
import com.candidjava.springhibernate.model.Student;

@Controller
public class RegisterController {
	@PostMapping("/Register.abcd") // 4.3
	public ModelAndView registerStudent(HttpServletRequest request, HttpServletResponse reponse) {
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		Student student = new Student();
		student.setName(name);
		student.setCourse(course);

		StudentDAOImpl studImpl = new StudentDAOImpl();

		studImpl.saveStudent(student);
//			int studentID = studImpl.getID(name, course);
//			student.setId(studentID);
		ModelAndView model = new ModelAndView("success");
		model.addObject("msg", "Student registered successfully");
		model.addObject("student", student);
		return model;
	}

	@GetMapping("/listStudents.abcd") // 4.3
	public ModelAndView getStudents() {
		StudentDAOImpl studImpl = new StudentDAOImpl();
		List<Student> list = studImpl.getStudents();
		ModelAndView model = new ModelAndView("list");
		model.addObject("msg", "Following students have been added");
		model.addObject("students", list);
		return model;
	}
}
