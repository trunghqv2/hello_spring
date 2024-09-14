package com.trung.indentity_service.service;

import com.trung.indentity_service.dto.request.PremissionRequest;
import com.trung.indentity_service.dto.response.PremissionResponse;
import com.trung.indentity_service.dto.response.PremissiontResponse;
import com.trung.indentity_service.entity.Premission;
import com.trung.indentity_service.mapper.PermissionMapper;
import com.trung.indentity_service.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

     public PremissionResponse create(PremissionRequest request) {
        Premission premission = permissionMapper.toPermission(request);
        premission = permissionRepository.save(premission);
        return permissionMapper.toPremissionResponse(premission);
    }

    public List<PremissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPremissionResponse).toList();
    }

    public  void delete(String premission) {
        permissionRepository.deleteById(premission);
    }
}
