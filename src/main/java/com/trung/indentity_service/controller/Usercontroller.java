package com.trung.indentity_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.entity.User;
import com.trung.indentity_service.service.UserService;


@RestController
public class Usercontroller {
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    User createUser (@RequestBody UserCreationRequest request){
        return userService.createRequest(request);
    }
    
}
