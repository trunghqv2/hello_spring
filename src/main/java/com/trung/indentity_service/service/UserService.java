package com.trung.indentity_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.entity.User;
import com.trung.indentity_service.repository.UserReposity;

@Service
public class UserService {
    @Autowired
    private UserReposity userReposity;

    public User createRequest (UserCreationRequest request){
        User user = new User();
        user.setUsername(request.getFirstName());
        user.setUsername(request.getLastName());
        user.setBod(request.getBod());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        return userReposity.save(user);
    }
}
