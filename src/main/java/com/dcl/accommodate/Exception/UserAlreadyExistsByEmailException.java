package com.dcl.accommodate.Exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserAlreadyExistsByEmailException extends RuntimeException {
    private final String message;
}
