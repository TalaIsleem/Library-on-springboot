package io.boksLibrary.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository <Employee, Long> {
		
	
}
