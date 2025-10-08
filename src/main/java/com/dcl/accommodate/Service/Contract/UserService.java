package com.dcl.accommodate.Service.Contract;

import com.dcl.accommodate.DTO.Request.UserRegistrationRequest;
import com.dcl.accommodate.DTO.Response.UserResponse;
import com.dcl.accommodate.model.User;

public interface UserService {

    void createUser(UserRegistrationRequest userRequest);

}
