package com.trung.indentity_service.mapper;


import com.trung.indentity_service.dto.request.PremissionRequest;
import com.trung.indentity_service.dto.response.PremissionResponse;
import com.trung.indentity_service.entity.Premission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Premission toPermission(PremissionRequest request);

    PremissionResponse toPremissionResponse(Premission premission);

}