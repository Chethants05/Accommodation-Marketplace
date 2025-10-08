package com.dcl.accommodate.DTO.Request;

import com.dcl.accommodate.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotNull(message = "first_name cannot be null")
        @NotBlank(message = "first_name Cannot be blank")
        @JsonFormat(pattern = "first_name")
        @Pattern(
                regexp = "^[A-Z][a-zA-Z\\\\s'-]{1,49}$",
                message = "starts with a capital letter, allows letters, spaces, hyphens, and apostrophes"
        )

        String firstName,

        @Pattern(
                regexp = "^[A-Z][a-zA-Z\\\\s'-]{0,49}$",
                message = "(starts with a capital letter, allows letters, spaces, hyphens, and apostrophes"
        )
        @JsonFormat(pattern = "last_name")
        String lastName,

        @NotNull(message = "date_of_birth cannot be null")
       @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
        LocalDate dateOfBirth,

        @NotNull(message = "email cannot be null")
        @NotBlank(message = "email cannot be blank")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
        message = "email must be in a valid format, it should contain @ anotation and it should end with .com")
        @JsonFormat(pattern = "email")
        String email,

        @NotNull(message = "phone_number cannot be null")
        @NotBlank(message = "phone_number cannot be blank")
        @Pattern(regexp =  "^[0-9]{10}$",
        message = "phone_number should contain starting +91 and then it should contain 10 digits")
        @JsonFormat(pattern = "phone_number")
        String phoneNumber,

        @NotNull(message = "password should not be null")
        @NotBlank(message = "password should not be blank")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,20}$",
                message = "Phone number must be 10 digits."
        )
        @JsonFormat(pattern = "password")
        String password,

        UserRole userRole
) {
}
