package com.marketplace.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TenantCreateRequest {

    @NotBlank(message = "Tenant name must not be blank")
    @Size(min = 3, max = 100, message = "Tenant name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Domain must not be blank")
    @Size(min = 3, max = 150, message = "Domain must be between 3 and 150 characters")
    @Pattern(
            regexp = "^[a-zA-Z0-9.-]+$",
            message = "Domain can contain only letters, numbers, dots and hyphens"
    )
    private String domain;
}
