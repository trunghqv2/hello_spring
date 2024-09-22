package com.trung.indentity_service.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.trung.indentity_service.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min= 3 , message= "USERNAME_INVALID")
    private String username;
    @Size(min= 5 , message= "INVALID_PASSWORD")
    private String password;
    private String firstName;
    private String lastName;
    @DobConstraint(min = 18, message = "INVALID_DOB")
    private LocalDate dob;
}
