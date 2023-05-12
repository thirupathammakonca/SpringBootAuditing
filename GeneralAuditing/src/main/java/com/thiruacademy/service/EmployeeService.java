package com.thiruacademy.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiruacademy.entity.Employee;
import com.thiruacademy.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public String saveEmployee(Employee request) {
		String currentUser = request.getLoggedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		request.setCreatedBy(currentUser);
		repository.save(request);
		return "Employee saved successfully...";

	}

	public String updateEmployee(int id, double salary, Employee request) {
		Employee employee = repository.findById(id).get();
		if (employee != null) {
			employee.setSalary(salary);
			employee.setModifiedBy(request.getLoggedInUser());
			repository.saveAndFlush(employee);
		} else {
			throw new RuntimeException("Employee not found with id : " + id);
		}
		return "Employee Updated successfully ";
	}
}
