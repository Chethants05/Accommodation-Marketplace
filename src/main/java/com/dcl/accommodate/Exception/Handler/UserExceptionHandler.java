package com.dcl.accommodate.Exception.Handler;

import com.dcl.accommodate.DTO.Wrapper.ApiAck;
import com.dcl.accommodate.Exception.UserAlreadyExistsByEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiAck> handleUserAlreadyExistByEmail(UserAlreadyExistsByEmailException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiAck(
                false,
                ex.getMessage()
        ));
    }
}
