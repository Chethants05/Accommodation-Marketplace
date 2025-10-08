package com.dcl.accommodate.Controller;
import com.dcl.accommodate.DTO.Request.UserRegistrationRequest;
import com.dcl.accommodate.DTO.Wrapper.ApiAck;
import com.dcl.accommodate.Service.Contract.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController

public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping("/user")
    public ResponseEntity<ApiAck> registerUser(@RequestBody @Valid UserRegistrationRequest request){
        userservice.createUser(request);
        return ResponseEntity.created(URI.create("/api/v1/profile")).body(new ApiAck(true,"User registered sucessfully"));
    }



}
