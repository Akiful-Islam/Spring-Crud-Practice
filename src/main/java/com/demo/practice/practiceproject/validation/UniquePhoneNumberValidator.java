package com.demo.practice.practiceproject.validation;

import com.demo.practice.practiceproject.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {
    private final EmployeeRepository employeeRepository;

    public UniquePhoneNumberValidator() {
        this.employeeRepository = null;
    }

    @Autowired
    public UniquePhoneNumberValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return !employeeRepository.existsByPhoneNumber(phoneNumber);
    }
}
