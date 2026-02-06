package com.marketplace.mapper;

import com.marketplace.dto.request.TenantCreateRequest;
import com.marketplace.dto.response.TenantResponse;
import com.marketplace.entity.Tenant;
import org.springframework.stereotype.Component;

@Component
public class TenantMapper {

    public Tenant toEntity(TenantCreateRequest request) {
        if (request == null) return null;

        Tenant tenant = new Tenant();
        tenant.setName(request.getName());
        tenant.setDomain(request.getDomain());
        return tenant;
    }

    public TenantResponse toResponse(Tenant tenant) {
        if (tenant == null) return null;

        TenantResponse response = new TenantResponse();
        response.setId(tenant.getId());
        response.setName(tenant.getName());
        response.setDomain(tenant.getDomain());
        response.setStatus(tenant.getStatus());
        return response;
    }
}
