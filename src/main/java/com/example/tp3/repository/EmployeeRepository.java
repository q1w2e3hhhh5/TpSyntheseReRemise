package com.example.tp3.repository;

import com.example.tp3.model.Admin;
import com.example.tp3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

}
