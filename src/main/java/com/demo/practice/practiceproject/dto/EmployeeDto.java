package com.demo.practice.practiceproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EmployeeDto {
    private int id;
    @NotEmpty(message = "First name is required.")
    private String firstName;
    @NotEmpty(message = "Last name is required.")
    private String lastName;
    @NotEmpty(message = "Email is required.")
    @Email(message = "Email is invalid.")
    private String email;
}
