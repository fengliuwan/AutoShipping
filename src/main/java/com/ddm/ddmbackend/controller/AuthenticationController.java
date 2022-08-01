package com.ddm.ddmbackend.controller;

import com.ddm.ddmbackend.model.Token;
import com.ddm.ddmbackend.model.User;
import com.ddm.ddmbackend.model.UserRole;
import com.ddm.ddmbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate/user")
    public Token authenticateUser(@RequestBody User user) {
        return authenticationService.authenticate(user, UserRole.ROLE_USER);
    }
    @PostMapping("/authenticate/staff")
    public Token authenticateStaff(@RequestBody User user) {
        return authenticationService.authenticate(user, UserRole.ROLE_STAFF);
    }

}
