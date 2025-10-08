package com.dcl.accommodate.DTO.Wrapper;

import com.dcl.accommodate.model.User;

import java.util.List;

public record ApiResponse<T>(
        String sucess,
        String message,
        T data
) {
}
