package com.candidjava.springJDBC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.candidjava.springJDBC.bean.AddressBean;
import com.candidjava.springJDBC.dao.AddressDAO;

//@Contoller
@RestController
public class RestStudentController {
	@PostMapping("/Register.abcd")
	public HttpStatus getFormData(@RequestBody AddressBean ab)

	{
		System.out.println("City..................." + ab.getCity());
		System.out.println("State..................." + ab.getState());
		System.out.println("PinCode..................." + ab.getPincode());

		AddressDAO dao = new AddressDAO();
		dao.insertAddress(ab.getCity(), ab.getState(), ab.getPincode());
		/*ModelAndView model = new ModelAndView("success");
		model.addObject("ab", ab);
		model.addObject("msg", "Welcome! Address has been inserted");*/
		return HttpStatus.CREATED; // 201
	}
}