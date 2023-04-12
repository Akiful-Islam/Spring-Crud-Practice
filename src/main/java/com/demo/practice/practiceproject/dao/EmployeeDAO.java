package com.demo.practice.practiceproject.dao;

import com.demo.practice.practiceproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllEmployees();

    Employee findEmployeeById(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(int id);



}
