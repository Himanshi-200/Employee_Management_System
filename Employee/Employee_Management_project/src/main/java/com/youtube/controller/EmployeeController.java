package com.youtube.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.model.Employee;
import com.youtube.repository.EmployeeRepo;
import com.youtube.serviceIMPL.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empervice;
	
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to Employee Management";
	}
	@PostMapping("/addEmp")
	public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
		Employee emp=empervice.addEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/removeEmp/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id){
		empervice.removeEmployee(id);
		return new ResponseEntity<String>("Remove Succefully",HttpStatus.ACCEPTED);
	}
	@GetMapping("/findEmp/{id}")
	public ResponseEntity<Optional<Employee>>findEmployeeById(@PathVariable int id){
		Optional<Employee> emps=empervice.findEmpById(id);
		return new ResponseEntity<Optional<Employee>>(emps,HttpStatus.ACCEPTED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> listOfEmployee(){
		List<Employee> lEmp=empervice.getAllEmployee();
		return new ResponseEntity<List<Employee>>(lEmp,HttpStatus.ACCEPTED);
	}
}
