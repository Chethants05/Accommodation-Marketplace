package com.dcl.accommodate.DTO.Wrapper;

import java.util.List;

public record ApiMultiErrorResponse(
        boolean sucess,
        String message,
        List<FieldError> errors
) {
}
