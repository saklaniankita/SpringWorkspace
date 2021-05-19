package com.autowire.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autowire.bean.Student;
import com.autowire.exception.NoScienceStudentException;
import com.autowire.exception.StudException;
import com.autowire.service.AutowireService;

@RestController
@RequestMapping("/")

public class AutowireController {

	@Autowired
	AutowireService autowireService;

	//Default Constructor called at the time of method call
	@PostMapping("/create")
	public HttpStatus createStudent(@RequestBody Student stud) {
		System.out.println("hey there........");
		Student savedStud = autowireService.insertStudent(stud);
		System.out.println(savedStud);
		return HttpStatus.OK;

	}

	//Persistence Constructor called after "in findAllStudents......"
	@GetMapping("/findAll")
	public ResponseEntity<Collection<Student>> findAllStudents() {
		System.out.println("in findAllStudents......");
		List<Student> students = autowireService.findStudents();
		//System.out.println(students.size());
		return new ResponseEntity<Collection<Student>>(students, HttpStatus.OK);

	}

	//Persistence Constructor called after "in findByRollNo....."
	@GetMapping("/findByRollNo/{roll}")
	public ResponseEntity<Student> findByRollNo(@PathVariable("roll") int rollid){
		System.out.println("in findByRollNo.....");
		Student stud;
		try {
			stud = autowireService.findByRollNo(rollid);
		}catch(NullPointerException e) {
			throw new StudException("Student with id " + rollid + " does not exist");
		}
		return new ResponseEntity<Student>(stud, HttpStatus.OK);
	}

	//Persistence Constructor called
	@GetMapping("/scienceStudents")
	public ResponseEntity<List<Student>> findScienceStudents() {
		System.out.println("in findScienceStudents...");
		List<Student> students = autowireService.findScienceStudents();
		if (students.size() == 0)
			throw new NoScienceStudentException("No Science Students Present");
		System.out.println(students);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}
	

	//Persistence Constructor called 4 times(equal to the no of results) 
	//at the time of method call
	@GetMapping("/findByAgeAndSection/{age}/{section}")
	public ResponseEntity<List<Student>> findByAgeAndSection(@PathVariable("age") int age,
			@PathVariable("section") String section) {
		System.out.println("in findByAgeAndSection........1");
		List<Student> students = autowireService.findByAgeAndSection(age, section);
		if (students.size() == 0)
			throw new NoScienceStudentException("No Student with given age and section");
		System.out.println(students);
		System.out.println("in findByAgeAndSection........2");
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}
	
	//Neither Default nor Persistence Constructor called
	@PutMapping("/updateStudentSection/{age}/{section}")
	public HttpStatus updateStudentSection(@PathVariable("age") int age,
			@PathVariable("section") String section) {
		autowireService.updateStudentSection(age, section);
		return HttpStatus.OK;
	}
}
