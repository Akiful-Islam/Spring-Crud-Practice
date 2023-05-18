package com.demo.practice.practiceproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NonNull
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;
    @NonNull
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email format invalid")
    @Column(unique = true)
    private String email;
    @NonNull
    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\d{11}$", message = "Phone number must only contain 11 digits")
    @Column(unique = true)
    private String phoneNumber;
    @NonNull
    @NotNull(message = "Position is required")
    @Enumerated(EnumType.STRING)
    private Position position;
}
