package com.trung.indentity_service.mapper;

import com.trung.indentity_service.dto.request.PermissionRequest;
import com.trung.indentity_service.dto.response.PermissionResponse;
import com.trung.indentity_service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
