package com.marketplace.controller;

import com.marketplace.dto.request.UserCreateRequest;
import com.marketplace.dto.response.ApiResponse;
import com.marketplace.dto.response.UserResponse;
import com.marketplace.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(
            @Valid @RequestBody UserCreateRequest request
    ) {
        return ApiResponse.success(
                userService.createUser(request)
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUser(
            @PathVariable Long id
    ) {
        return ApiResponse.success(
                userService.getUserById(id)
        );
    }

    @GetMapping
    public ApiResponse<Page<UserResponse>> getUsersByTenant(
            @RequestParam String tenantId,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        return ApiResponse.success(
                userService.getUsersByTenant(tenantId, pageable)
        );
    }
}
