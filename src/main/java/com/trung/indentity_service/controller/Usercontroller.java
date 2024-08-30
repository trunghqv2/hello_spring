package com.trung.indentity_service.controller;

import com.trung.indentity_service.dto.request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.entity.User;
import com.trung.indentity_service.service.UserService;

import java.util.List;


@RestController()
@RequestMapping("/users")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createRequest(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@RequestParam("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request) {
            return userService.updateUser(userId, request);
    }
}
