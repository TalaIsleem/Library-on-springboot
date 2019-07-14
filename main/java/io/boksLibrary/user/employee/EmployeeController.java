package io.boksLibrary.user.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.boksLibrary.book.novels.Novel;
import io.boksLibrary.book.novels.NovelServiceIMP;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceIMP EmployeeServiceIMP;
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		return EmployeeServiceIMP.getEmployees();
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Long id){
		return EmployeeServiceIMP.getEmployee(id);
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee){
		EmployeeServiceIMP.addEmployee(employee);
	//	return novel;
	}
	
}
