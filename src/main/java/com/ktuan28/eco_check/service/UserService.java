package com.ktuan28.eco_check.service;

import com.ktuan28.eco_check.dto.request.UserCreateRequest;
import com.ktuan28.eco_check.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse createUser(UserCreateRequest request);
}
