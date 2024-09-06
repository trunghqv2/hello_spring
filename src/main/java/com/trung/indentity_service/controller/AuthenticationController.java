package com.trung.indentity_service.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trung.indentity_service.dto.request.ApiResponse;
import com.trung.indentity_service.dto.request.AuthenticationRequest;
import com.trung.indentity_service.dto.response.AuthenticationResponse;
import com.trung.indentity_service.service.AuthenticationService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest Request) {
        boolean result = authenticationService.authenticate(Request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }
}
