package com.demo.practice.practiceproject.service;


import com.demo.practice.practiceproject.entity.Employee;
import com.demo.practice.practiceproject.exception.EmployeeNotFoundException;
import com.demo.practice.practiceproject.exception.InvalidFieldNameException;
import com.demo.practice.practiceproject.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee findById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee update(Map<String, String> updates, long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return employeeRepository.save(updateFields(existingEmployee, updates));
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(long id) {
        employeeRepository.findById(id).ifPresentOrElse(
                employee -> employeeRepository.deleteById(id),
                () -> {
                    throw new EmployeeNotFoundException("Employee not found with id: " + id);
                }
        );
    }

    private Employee updateFields(Employee existingEmployee, Map<String, String> updates) {
        updates.forEach((key, value) -> {
            switch (key) {
                case "firstName" -> existingEmployee.setFirstName(value);
                case "lastName" -> existingEmployee.setLastName(value);
                case "email" -> existingEmployee.setEmail(value);
                case "id" -> throw new InvalidFieldNameException("Cannot update id field");
                default -> throw new InvalidFieldNameException("Invalid field name: " + key);
            }
        });
        return existingEmployee;
    }

}