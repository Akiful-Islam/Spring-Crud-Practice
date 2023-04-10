package com.demo.practice.practiceproject.service;

import com.demo.practice.practiceproject.dao.EmployeeDAO;
import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAllEmployees();
    }
}
