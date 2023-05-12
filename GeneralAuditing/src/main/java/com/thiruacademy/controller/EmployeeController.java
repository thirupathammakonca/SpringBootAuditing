package com.thiruacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiruacademy.entity.Employee;
import com.thiruacademy.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody Employee request) {
		return service.saveEmployee(request);
	}

	@PutMapping("/updateEmployee/{id}/{salary}")
	public String updateEmployeeSalary(@PathVariable int id, @PathVariable double salary,
			@RequestBody Employee request) {
		return service.updateEmployee(id, salary, request);
	}
}
