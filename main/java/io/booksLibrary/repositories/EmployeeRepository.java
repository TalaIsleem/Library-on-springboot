package io.booksLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.booksLibrary.entities.Employee;


public interface EmployeeRepository extends JpaRepository <Employee, Long> {
		
	
}
