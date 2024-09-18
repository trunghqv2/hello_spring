package com.trung.indentity_service.mapper;

import com.trung.indentity_service.dto.request.RoleRequest;
import com.trung.indentity_service.dto.response.RoleResponse;
import com.trung.indentity_service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions",ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
