package io.booksLibrary.services;

import java.util.List;

import io.booksLibrary.entities.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(Long id);
	
}
