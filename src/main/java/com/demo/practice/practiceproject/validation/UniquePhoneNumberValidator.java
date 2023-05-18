package com.demo.practice.practiceproject.validation;

import com.demo.practice.practiceproject.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {
    private final EmployeeRepository employeeRepository;

    public UniquePhoneNumberValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !employeeRepository.existsByPhoneNumber(s);
    }
}
