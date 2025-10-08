package com.dcl.accommodate.DTO.Wrapper;


public record FieldError(
        String rejectedField,
        Object rejectedValue,
        String message
) {
}
