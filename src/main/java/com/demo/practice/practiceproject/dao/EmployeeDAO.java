package com.demo.practice.practiceproject.dao;

import com.demo.practice.practiceproject.entity.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostConstruct
    public void init() {
        System.out.println("Employee DAO created");
    }


    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }


    public Employee findById(int id) {

        Optional<Employee> employee = Optional.ofNullable(entityManager.find(Employee.class, id));
        if (employee.isEmpty()) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return employee.get();
    }


    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }


    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Employee DAO destroyed");
    }
}
