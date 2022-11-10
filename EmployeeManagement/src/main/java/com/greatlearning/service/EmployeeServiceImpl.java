package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Employee;
import com.greatlearning.repository.employeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private employeeRepository repo;
	
	@Override
	public Employee save(Employee employee) {
        Employee savedemployee=this.repo.save(employee);
		return savedemployee;
	}

	@Override
	public List<Employee> findAll() {
        List<Employee> employees =this.repo.findAll();
		return employees;
	}

	@Override
	public Employee findById(int id) {
        Optional<Employee> optionalEmployee=this.repo.findById(id);
        if(optionalEmployee.isPresent()) {
        	return optionalEmployee.get();
        }else {
        	throw new IllegalArgumentException("Invalid Employee id is passed");
        }
	}
	
	public Employee updateEmployee(int id, Employee updatedEmployee) {
		System.out.println("passed id is");
		Employee empforUpdate = this.findById(id);
		empforUpdate.setFirstName(updatedEmployee.getFirstName());
		empforUpdate.setLastName(updatedEmployee.getLastName());
		empforUpdate.setEmail(updatedEmployee.getEmail());
		this.repo.save(empforUpdate);
		return empforUpdate;
	}

	@Override
	public void deleteEmployeeById(int id) {
         this.repo.deleteById(id);		
	}

	@Override
	public List<Employee> findByFirstNameOrderByLastNameAsc(String firstName) {
		List<Employee> employees=this.repo.findByFirstNameOrderByLastNameAsc(firstName);
		return employees;
	}

	@Override
	public List<Employee> findByFirstNameOrderByLastNameDesc(String firstName) {
		List<Employee> employees=this.repo.findByFirstNameOrderByLastNameDesc(firstName);		
		return employees;
	}

	
}
