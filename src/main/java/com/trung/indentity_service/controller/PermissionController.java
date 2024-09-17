package com.trung.indentity_service.controller;

import com.trung.indentity_service.dto.request.ApiResponse;
import com.trung.indentity_service.dto.request.PermissionRequest;
import com.trung.indentity_service.dto.response.PermissionResponse;
import com.trung.indentity_service.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController()
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {
    PermissionService permissionService;
    @PostMapping
    ApiResponse<PermissionResponse> create(PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder().result(permissionService.create(request)).build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> findAll() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }
    @DeleteMapping("/{permission}")
    ApiResponse<Void> delete (@PathVariable String permission) {
        permissionService.delete(permission);
        return ApiResponse.<Void>builder()
                .build();
    }
}
