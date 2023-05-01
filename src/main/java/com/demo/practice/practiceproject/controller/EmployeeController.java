package com.demo.practice.practiceproject.controller;

import com.demo.practice.practiceproject.dto.EmployeeDto;
import com.demo.practice.practiceproject.exception.EmployeeNotFoundException;
import com.demo.practice.practiceproject.exception.ErrorResponse;
import com.demo.practice.practiceproject.exception.InvalidFieldNameException;
import com.demo.practice.practiceproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> findAllEmployees(Pageable pageable) {
        return ResponseEntity.ok(employeeService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEmployeeById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(employeeService.findById(id));
        } catch (EmployeeNotFoundException e) {
            var status = HttpStatus.NOT_FOUND;
            var errorResponse = new ErrorResponse(status.toString(), e.getMessage(), "/api/employees/" + id);
            return ResponseEntity.status(status).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Map<String, String> updates, @PathVariable long id) {
        try {
            return ResponseEntity.ok(employeeService.update(updates, id));
        } catch (InvalidFieldNameException e) {
            var status = HttpStatus.BAD_REQUEST;
            var errorResponse = new ErrorResponse(status.toString(), e.getMessage(), "/api/employees/" + id);
            return ResponseEntity.status(status).body(errorResponse);
        } catch (EmployeeNotFoundException e) {
            var status = HttpStatus.NOT_FOUND;
            var errorResponse = new ErrorResponse(status.toString(), e.getMessage(), "/api/employees/" + id);
            return ResponseEntity.status(status).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EmployeeNotFoundException e) {
            var status = HttpStatus.NOT_FOUND;
            var errorResponse = new ErrorResponse(status.toString(), e.getMessage(), "/api/employees/" + id);
            return ResponseEntity.status(status).body(errorResponse);
        }

    }
}

