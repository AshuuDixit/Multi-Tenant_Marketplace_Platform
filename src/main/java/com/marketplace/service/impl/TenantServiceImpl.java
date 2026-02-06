package com.marketplace.service.impl;

import com.marketplace.dto.request.TenantCreateRequest;
import com.marketplace.dto.response.TenantResponse;
import com.marketplace.entity.Tenant;
import com.marketplace.entity.TenantStatus;
import com.marketplace.exception.BadRequestException;
import com.marketplace.exception.ResourceNotFoundException;
import com.marketplace.mapper.TenantMapper;
import com.marketplace.repository.TenantRepository;
import com.marketplace.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Override
    public TenantResponse createTenant(TenantCreateRequest request) {


        tenantRepository.findByDomain(request.getDomain()).ifPresent(t -> {
            throw new BadRequestException("Tenant with domain '" + request.getDomain() + "' already exists");
        });


        Tenant tenant = tenantMapper.toEntity(request);


        tenant.setStatus(TenantStatus.ACTIVE);


        Tenant savedTenant = tenantRepository.save(tenant);


        return tenantMapper.toResponse(savedTenant);
    }

    @Override
    public TenantResponse getTenantById(Long id) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tenant not found with id: " + id));

        return tenantMapper.toResponse(tenant);
    }

    @Override
    public Page<TenantResponse> getAllTenants(Pageable pageable) {
        return tenantRepository.findAll(pageable).map(tenantMapper::toResponse);
    }
}
