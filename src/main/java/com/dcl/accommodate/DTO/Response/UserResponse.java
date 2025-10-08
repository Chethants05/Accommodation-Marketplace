package com.dcl.accommodate.DTO.Response;

import com.dcl.accommodate.enums.UserRole;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record UserResponse(
        UUID userId,
         String firstName,
         String lastName,
         LocalDate dateOfBirth,
         String email,
         List<UserRole> roles,
         Instant createdDate,
         Instant lastUpdatedAt
) {
}
