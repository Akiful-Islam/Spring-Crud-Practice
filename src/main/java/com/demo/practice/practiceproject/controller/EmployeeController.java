package com.demo.practice.practiceproject.controller;

import com.demo.practice.practiceproject.entity.Employee;
import com.demo.practice.practiceproject.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Employee Controller created");
    }

    @GetMapping
    public Page<Employee> findAllEmployees(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @RequestParam(defaultValue = "asc") String sortOrder) {
        return employeeService.findAll(page, size, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return employee;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        Employee dbEmployee = employeeService.findById(id);
        if (dbEmployee == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        dbEmployee.setFirstName(employee.getFirstName());
        dbEmployee.setLastName(employee.getLastName());
        dbEmployee.setEmail(employee.getEmail());
        return employeeService.save(dbEmployee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeService.deleteById(id);
        return "Deleted employee with id: " + id + "\n name: " + employee.getFirstName() + " " + employee.getLastName() + "\n email: " + employee.getEmail();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Employee Controller destroyed");
    }
}