package com.trung.indentity_service.mapper;


import com.trung.indentity_service.dto.request.PremissionRequest;
import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.dto.request.UserUpdateRequest;
import com.trung.indentity_service.dto.response.PremissionResponse;
import com.trung.indentity_service.dto.response.UserResponse;
import com.trung.indentity_service.entity.Premission;
import com.trung.indentity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PremissionMapper {
    Premission toPremission(PremissionRequest request);

    PremissionResponse toPremissionResponse(Premission premission);

}