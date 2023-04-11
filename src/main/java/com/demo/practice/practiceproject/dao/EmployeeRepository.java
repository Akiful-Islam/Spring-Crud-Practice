package com.demo.practice.practiceproject.dao;

import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Job is done by Spring Data JPA
}
