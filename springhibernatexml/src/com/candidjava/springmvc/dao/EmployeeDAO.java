package com.candidjava.springmvc.dao;

import com.candidjava.springmvc.entity.Employee;

public interface EmployeeDAO {
	public void createEmployee(Employee employee);
	public Employee getEmployee(Employee employee);

}
