package com.marketplace.dto.response;

import com.marketplace.entity.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String tenantId;
    private UserStatus status;
    private LocalDateTime createdAt;
}
