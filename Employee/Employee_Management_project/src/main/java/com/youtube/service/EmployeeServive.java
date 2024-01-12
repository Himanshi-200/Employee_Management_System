package com.youtube.service;

import java.util.List;
import java.util.Optional;

import com.youtube.model.Employee;

public interface EmployeeServive {

	public Employee addEmployee(Employee employee);
	public String removeEmployee(int id);
	public Optional<Employee> findEmpById(int id);
	public List<Employee> getAllEmployee();
	public String updateEmployee(int id);
}
