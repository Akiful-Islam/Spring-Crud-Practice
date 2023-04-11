package com.demo.practice.practiceproject.service;

import com.demo.practice.practiceproject.dao.EmployeeRepository;
import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return result.get();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
