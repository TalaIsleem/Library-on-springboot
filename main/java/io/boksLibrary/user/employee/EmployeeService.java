package io.boksLibrary.user.employee;

import java.util.List;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(Long id);
	
}
