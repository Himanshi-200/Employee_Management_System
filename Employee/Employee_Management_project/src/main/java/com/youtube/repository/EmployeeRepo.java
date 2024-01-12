package com.youtube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
