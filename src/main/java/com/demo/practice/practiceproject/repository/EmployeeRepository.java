package com.demo.practice.practiceproject.repository;

import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
