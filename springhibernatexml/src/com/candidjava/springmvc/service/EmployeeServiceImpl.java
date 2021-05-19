package com.candidjava.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.springmvc.dao.EmployeeDAO;
import com.candidjava.springmvc.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	//EmployeeDAO employeeDAO =new EmployeeDAOImpl();
	
	@Override
	public void createEmployee(Employee employee) 
	{
		employeeDAO.createEmployee(employee);
		
	}

	@Override
	public Employee getEmployee(Employee employee) {
		//
		//
		//
		return employeeDAO.getEmployee(employee);
	}
	
	
	
	

}
