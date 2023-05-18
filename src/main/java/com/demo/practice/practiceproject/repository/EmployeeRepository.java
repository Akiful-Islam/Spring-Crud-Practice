package com.demo.practice.practiceproject.repository;

import com.demo.practice.practiceproject.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Page<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase (String firstName, String lastName, Pageable pageable);
    Page<Employee> findByPhoneNumberContaining( String phoneNumber, Pageable pageable);
}
