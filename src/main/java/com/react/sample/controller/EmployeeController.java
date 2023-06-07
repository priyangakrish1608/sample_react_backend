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
@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@Autowired
	com.react.sample.model.EmployeeService EmployeeService;
	
	@GetMapping("/employee")
	public List<EmployeeEntity> retrieveAllEmployees() {
		return EmployeeService.findAll();	
    }
	
	@PostMapping("/employee")
	public EmployeeEntity  createEmployees(@RequestBody EmployeeEntity employeeBean) {
		return EmployeeService.save(employeeBean);
	}
	
	@GetMapping ("/employees/{Id}")
	public EmployeeEntity retrieveEmployeeById(@PathVariable int Id) {
		return EmployeeService.findOne(Id);
	}
	
	@PutMapping
	public EmployeeEntity updateEmployees(@RequestBody EmployeeEntity employeeBean) {
		return EmployeeService.update(employeeBean);
	}
	
	@DeleteMapping("/employees/(Id)")
	public void deleteEmployees(@PathVariable int Id) {
		EmployeeService.delete(Id);
	}
    

}
        
       
 

