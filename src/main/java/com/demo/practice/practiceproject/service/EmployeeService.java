package com.demo.practice.practiceproject.service;


import com.demo.practice.practiceproject.entity.Employee;
import com.demo.practice.practiceproject.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Employee Service created");
    }

    public Page<Employee> findAll(int page, int size, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        var employeeIterable = employeeRepository.findAll();
        List<Employee> employees = StreamSupport.stream(employeeIterable.spliterator(), false).toList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), employees.size());
        return new PageImpl<>(employees.subList(start, end), pageable, employees.size());
    }

    public Employee findById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return employee.get();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Employee Service destroyed");
    }
}