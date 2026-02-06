package com.marketplace.dto.response;

import com.marketplace.entity.TenantStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TenantResponse {

    private Long id;
    private String name;
    private String domain;
    private TenantStatus status;
}
