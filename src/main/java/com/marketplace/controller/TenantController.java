package com.marketplace.controller;

import com.marketplace.dto.request.TenantCreateRequest;
import com.marketplace.dto.response.ApiResponse;
import com.marketplace.dto.response.TenantResponse;
import com.marketplace.service.TenantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping
    public ApiResponse<TenantResponse> createTenant(
            @Valid @RequestBody TenantCreateRequest request) {

        return ApiResponse.success(
                tenantService.createTenant(request)
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<TenantResponse> getTenantById(@PathVariable Long id) {

        return ApiResponse.success(
                tenantService.getTenantById(id)
        );
    }

    @GetMapping
    public ApiResponse<Page<TenantResponse>> getAllTenants(Pageable pageable) {

        return ApiResponse.success(
                tenantService.getAllTenants(pageable)
        );
    }
}
