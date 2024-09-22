package com.trung.indentity_service.mapper;


import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.dto.request.UserUpdateRequest;
import com.trung.indentity_service.dto.response.UserResponse;
import com.trung.indentity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    //    @Mapping(target = "username", ignore = true)
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}