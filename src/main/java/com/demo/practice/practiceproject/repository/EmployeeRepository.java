package com.demo.practice.practiceproject.repository;

import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase (String firstName, String lastName);
    List<Employee> findByPhoneNumberContaining( String phoneNumber);
}
