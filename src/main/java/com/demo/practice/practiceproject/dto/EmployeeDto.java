package com.demo.practice.practiceproject.dto;

import com.demo.practice.practiceproject.entity.Position;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EmployeeDto(
        int id,
        @NotEmpty(message = "First name cannot be empty")
        String firstName,
        @NotEmpty(message = "Last name cannot be empty")
        String lastName,
        @NotEmpty(message = "Email cannot be empty")
                @Email(message = "Email format invalid")
        String email,
        @NotEmpty(message = "Phone number cannot be empty")
        @Pattern(regexp = "^\\d{11}$", message = "Phone number must only contain 11 digits")
        String phoneNumber,
        @NotNull(message = "Position is required")
        Position position) {
}
