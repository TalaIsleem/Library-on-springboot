package io.boksLibrary.user.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceIMP {
	@Autowired
	EmployeeRepository employeeRepository;

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList <>();
		employeeRepository.findAll().forEach(employees::add);
		 return employees;
	}
	
	public Employee getEmployee(Long id) {
		return employeeRepository.findOne(id);
	}
}
