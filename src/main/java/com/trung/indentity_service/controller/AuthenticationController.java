package com.trung.indentity_service.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nimbusds.jose.JOSEException;
import com.trung.indentity_service.dto.request.ApiResponse;
import com.trung.indentity_service.dto.request.AuthenticationRequest;
import com.trung.indentity_service.dto.request.IntrospectRequest;
import com.trung.indentity_service.dto.request.UserCreationRequest;
import com.trung.indentity_service.dto.response.AuthenticationResponse;
import com.trung.indentity_service.dto.response.IntrospectResponse;
import com.trung.indentity_service.dto.response.UserResponse;
import com.trung.indentity_service.entity.User;
import com.trung.indentity_service.service.AuthenticationService;
import com.trung.indentity_service.service.UserService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    UserService userService;

    @PostMapping("/register")
    User register(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    };

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
