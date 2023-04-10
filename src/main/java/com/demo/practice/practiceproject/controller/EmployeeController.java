package com.demo.practice.practiceproject.controller;

import com.demo.practice.practiceproject.dao.EmployeeDAO;
import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api")
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeDAO.findAllEmployees();
    }
}
