package com.react.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.react.sample.model.EmployeeEntity;
import com.react.sample.model.EmployeeService; // Corrected import

@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; // Updated variable name and corrected package

	@GetMapping("/employee")
	public List<EmployeeEntity> retrieveAllEmployees() {
		return employeeService.findAll();	
    }
	
	@PostMapping("/employee")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) { // Corrected method name and parameter
		return employeeService.save(employeeEntity);
	}
	
	@GetMapping("/employees/{id}") // Updated path variable name
	public EmployeeEntity retrieveEmployeeById(@PathVariable int id) { // Updated path variable name
		return employeeService.findOne(id);
	}
	
	@PutMapping("/employees/{id}") // Updated path variable name
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) { // Corrected method name and parameter
		return employeeService.update(employeeEntity);
	}
	
	@DeleteMapping("/employees/{id}") // Updated path variable name
	public void deleteEmployee(@PathVariable int id) { // Updated path variable name
		employeeService.delete(id);
	}
}
        
       
 

