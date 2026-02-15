package com.marketplace.service.impl;

import com.marketplace.dto.request.UserCreateRequest;
import com.marketplace.dto.response.UserResponse;
import com.marketplace.entity.User;
import com.marketplace.entity.UserStatus;
import com.marketplace.exception.BadRequestException;
import com.marketplace.exception.ResourceNotFoundException;
import com.marketplace.mapper.UserMapper;
import com.marketplace.repository.UserRepository;
import com.marketplace.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserCreateRequest request) {

        userRepository.findByEmailAndTenantId(
                request.getEmail(),
                request.getTenantId()
        ).ifPresent(u -> {
            throw new BadRequestException("User already exists");
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStatus(UserStatus.ACTIVE);

        User saved = userRepository.save(user);
        return userMapper.toResponse(saved);
    }

    @Override
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public Page<UserResponse> getUsersByTenant(
            String tenantId,
            Pageable pageable
    ) {
        return userRepository
                .findAllByTenantId(tenantId, pageable)
                .map(userMapper::toResponse);
    }
}

