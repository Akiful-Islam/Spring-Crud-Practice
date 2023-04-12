package com.demo.practice.practiceproject.service;

import com.demo.practice.practiceproject.dao.EmployeeDAO;
import com.demo.practice.practiceproject.entity.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostConstruct
    public void init() {
        System.out.println("Employee Service created");
    }

    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Employee Service destroyed");
    }
}
