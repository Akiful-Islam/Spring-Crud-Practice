package com.demo.practice.practiceproject.repository;

import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
