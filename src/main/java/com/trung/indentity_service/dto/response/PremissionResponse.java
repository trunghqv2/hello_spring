package com.trung.indentity_service.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trung.indentity_service.repository.PremissionRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PremissionResponse {
    String name;
    String description;
}
