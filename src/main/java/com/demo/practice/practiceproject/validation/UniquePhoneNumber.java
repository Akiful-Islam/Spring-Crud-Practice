package com.demo.practice.practiceproject.validation;

import jakarta.validation.Payload;

public @interface UniquePhoneNumber {
    String message() default "Phone number already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
