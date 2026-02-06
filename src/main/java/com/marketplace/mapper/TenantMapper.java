package com.marketplace.mapper;

import com.marketplace.dto.request.TenantCreateRequest;
import com.marketplace.dto.response.TenantResponse;
import com.marketplace.entity.Tenant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TenantMapper {

    Tenant toEntity(TenantCreateRequest request);

    TenantResponse toResponse(Tenant tenant);
}
