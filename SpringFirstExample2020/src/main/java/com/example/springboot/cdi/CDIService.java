package com.example.springboot.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
@Named
public class CDIService {
	//@Autowired
	@Inject
	private CDIDao cdiDao;

	public CDIDao getCdiDao() {
		return cdiDao;
	}

	public void setCdiDao(CDIDao cdiDao) {
		this.cdiDao = cdiDao;
	}
	
}
