package com.demo.practice.practiceproject.validation;

import com.demo.practice.practiceproject.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final EmployeeRepository employeeRepository;

    public UniqueEmailValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !employeeRepository.existsByEmail(s);
    }
}
