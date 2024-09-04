package com.trung.indentity_service.service;

import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.dto.request.UserUpdateRequest;
import com.trung.indentity_service.dto.response.UserResponse;
import com.trung.indentity_service.entity.User;
import com.trung.indentity_service.exception.AppException;
import com.trung.indentity_service.exception.ErrorCode;
import com.trung.indentity_service.mapper.UserMapper;
import com.trung.indentity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService {
    UserRepository userRepository;
     UserMapper userMapper;

    public User createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        return userRepository.save(user);
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

       userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
}
