package com.demo.practice.practiceproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@Data
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private String email;
}
