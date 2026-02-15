package com.marketplace.service;

import com.marketplace.dto.request.UserCreateRequest;
import com.marketplace.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse getUserById(Long id);

    Page<UserResponse> getUsersByTenant(
            String tenantId,
            Pageable pageable
    );
}
