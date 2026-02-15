package com.marketplace.mapper;

import com.marketplace.dto.request.UserCreateRequest;
import com.marketplace.dto.response.UserResponse;
import com.marketplace.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateRequest request);

    UserResponse toResponse(User user);
}

