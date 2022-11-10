package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.greatlearning.entity.Employee;
import com.greatlearning.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> fetchAllEmployees(){
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee fetchEmployeesById(@PathVariable("id")int id){
		return this.service.findById(id);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.service.save(employee);
	}
	
	@PutMapping("/{id}")
	public Employee UpdateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		return this.service.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeesById(@PathVariable("id")int id){
		this.service.deleteEmployeeById(id);
	}
	
	@GetMapping("/firstAsc")
	public List<Employee> fetchEmployeebyNameAsc(@RequestParam(name="firstName",defaultValue="al",required=false)String firstName){
		return this.service.findByFirstNameOrderByLastNameAsc(firstName);
	}
	@GetMapping("/firstDesc")
	public List<Employee> fetchEmployeebyNameDesc(@RequestParam(name="firstName",defaultValue="al",required=false)String firstName){
		return this.service.findByFirstNameOrderByLastNameDesc(firstName);
	}
}

