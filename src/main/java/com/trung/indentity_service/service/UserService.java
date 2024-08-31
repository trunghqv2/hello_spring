package com.trung.indentity_service.service;

import com.trung.indentity_service.dto.request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.entity.User;
import com.trung.indentity_service.repository.UserReposity;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReposity userReposity;

    public User createRequest(UserCreationRequest request) {
        User user = new User();
        if (userReposity.existsByUsername(request.getUsername()))
            throw new RuntimeException("Username existed");
        user.setUsername(request.getUsername());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setDob(request.getDob());
        user.setPassword(request.getPassword());
        return userReposity.save(user);
    }

    public List<User> getUser() {
        return userReposity.findAll();
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setDob(request.getDob());
        user.setPassword(request.getPassword());
        return userReposity.save(user);
    }

    public void deletUser(String userId) {
        userReposity.deleteById(userId);
    }

    public List<User> getUsers() {
        return userReposity.findAll();
    }

    public User getUser(String userId) {
        return userReposity.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
