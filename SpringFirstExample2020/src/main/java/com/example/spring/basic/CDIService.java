package com.example.spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDIService {
	@Autowired
	private CDIDao cdiDao;

	public CDIDao getCdiDao() {
		return cdiDao;
	}

	public void setCdiDao(CDIDao cdiDao) {
		this.cdiDao = cdiDao;
	}
	
}
