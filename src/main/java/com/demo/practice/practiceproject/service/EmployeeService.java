package com.demo.practice.practiceproject.service;


import com.demo.practice.practiceproject.dto.EmployeeDto;
import com.demo.practice.practiceproject.entity.Employee;
import com.demo.practice.practiceproject.entity.Position;
import com.demo.practice.practiceproject.exception.EmployeeNotFoundException;
import com.demo.practice.practiceproject.exception.InvalidFieldNameException;
import com.demo.practice.practiceproject.repository.EmployeeRepository;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Validator validator;

    public EmployeeService(EmployeeRepository employeeRepository, Validator validator) {
        this.employeeRepository = employeeRepository;
        this.validator = validator;
    }

    public Page<EmployeeDto> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(this::toDto);
    }

    public EmployeeDto findById(long id) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return toDto(employee);
    }

    public EmployeeDto save(EmployeeDto employeeDto) {
        return toDto(employeeRepository.save(toEntity(employeeDto)));
    }

    public EmployeeDto update(Map<String, String> updates, long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return toDto(employeeRepository.save(updateFields(existingEmployee, updates)));
    }
    public void delete(long id) {
        employeeRepository.findById(id).ifPresentOrElse(
                employee -> employeeRepository.deleteById(id),
                () -> {
                    throw new EmployeeNotFoundException("Employee not found with id: " + id);
                }
        );
    }

    private Employee updateFields(Employee existingEmployee, Map<String, String> updates) {
        updates.forEach((key, value) -> {
            switch (key) {
                case "firstName" -> existingEmployee.setFirstName(value);
                case "lastName" -> existingEmployee.setLastName(value);
                case "email" -> existingEmployee.setEmail(value);
                case "phoneNumber" -> existingEmployee.setPhoneNumber(value);
                case "position" -> existingEmployee.setPosition(Position.valueOf(value));
                case "id" -> throw new InvalidFieldNameException("Cannot update id field");
                default ->
                        throw new InvalidFieldNameException("Employee does not have field: " + key + ". Valid fields are: firstName, lastName, email");
            }
        });
        validateFields(toDto(existingEmployee));
        return existingEmployee;

    }


    private void validateFields(EmployeeDto existingEmployee) {
        var violations = validator.validate(existingEmployee);

        if (!violations.isEmpty()) {
            var message = new StringBuilder();
            for (var violation : violations) {
                message.append(violation.getMessage()).append(", ");
            }
            message.delete(message.length() - 2, message.length());
            String finalMessage;
            if (violations.size() > 1) {
                finalMessage = "Multiple invalid fields: " + message;
            } else {
                finalMessage = "Invalid field: " + message;
            }
            throw new InvalidFieldNameException(finalMessage);
        }
    }


    private Employee toEntity(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.firstName(),
                employeeDto.lastName(),
                employeeDto.email(),
                employeeDto.phoneNumber(),
                employeeDto.position()
        );}

    private EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getPosition()
        );
    }

}

