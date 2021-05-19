package com.example;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class FirstController extends AbstractController {

	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Employee emp = new Employee(1,"ABC");
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", emp);
		mv.addObject("msg","Hey Welcome");
		mv.addObject("date",new Date());
		mv.setViewName("welcome");
		return mv;
	}

}
