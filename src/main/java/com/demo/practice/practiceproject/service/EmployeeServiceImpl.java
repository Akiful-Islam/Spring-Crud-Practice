package com.demo.practice.practiceproject.service;

import com.demo.practice.practiceproject.dao.EmployeeDAO;
import com.demo.practice.practiceproject.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteEmployeeById(id);
    }
}
