package com.dcl.accommodate.Service.Impl;

import com.dcl.accommodate.DTO.Request.UserRegistrationRequest;
import com.dcl.accommodate.DTO.Response.UserResponse;
import com.dcl.accommodate.Exception.UserAlreadyExistsByEmailException;
import com.dcl.accommodate.Service.Contract.UserService;
import com.dcl.accommodate.enums.UserRole;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserRegistrationRequest userRequest) {
       if(userRepository.existsByEmail(userRequest.email())){
           throw new UserAlreadyExistsByEmailException("User Account Already Exists by given email");
       }

       var user = this.toUser(userRequest);
       //All users are by default Guest
       user.setUserRole(UserRole.GUEST);
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
    }
    private User toUser(UserRegistrationRequest request){
        var user= User.builder().
                firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .dateOfBirth(request.dateOfBirth())
                .avatar(request.avatar())
                .build();
        return user;
    }


}
