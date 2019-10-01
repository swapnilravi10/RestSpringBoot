package com.swapnil.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController	
public class EmployeeController 
{
	@Autowired
	EmployeeDao employee;
	
	@PostMapping("addEmployee")
	public Employee addEmployee(Employee emp)
	{
		 return employee.save(emp);
	}
	
	@GetMapping("getEmployees")
	public List<Employee> getEmployees()
	{
		return employee.findAll();
	}
	
	@GetMapping("getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") int id)
	{
		return employee.findById(id);
	}
	
	@DeleteMapping("employee/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		employee.deleteById(id);
		
		return "deleted";
	}
	
	@PutMapping("updateEmployee")
	public Employee updateEmployee(Employee emp)
	{
		return employee.save(emp);
	}
}
