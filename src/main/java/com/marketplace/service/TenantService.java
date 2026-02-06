package com.marketplace.service;

import com.marketplace.dto.request.TenantCreateRequest;
import com.marketplace.dto.response.TenantResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TenantService {
    TenantResponse createTenant(TenantCreateRequest request);

    TenantResponse getTenantById(Long id);

    Page<TenantResponse> getAllTenants(Pageable pageable);

}
