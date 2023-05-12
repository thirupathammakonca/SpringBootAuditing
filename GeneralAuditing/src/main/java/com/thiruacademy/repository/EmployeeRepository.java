package com.thiruacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiruacademy.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
