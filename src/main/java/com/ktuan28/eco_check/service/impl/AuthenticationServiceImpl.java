package com.ktuan28.eco_check.service.impl;

import com.ktuan28.eco_check.dto.request.AuthenticationRequest;
import com.ktuan28.eco_check.dto.response.AuthenticationResponse;
import com.ktuan28.eco_check.dto.response.UserResponse;
import com.ktuan28.eco_check.entity.User;
import com.ktuan28.eco_check.exception.AppException;
import com.ktuan28.eco_check.exception.ErrorCode;
import com.ktuan28.eco_check.mapper.UserMapper;
import com.ktuan28.eco_check.repository.UserRepository;
import com.ktuan28.eco_check.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationServiceImpl implements AuthenticationService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }

        UserResponse userResponse = UserMapper.toResponse(user);


        return AuthenticationResponse.builder()
                .authenticated(true)
                .token(null)   // Chưa cần token
                .user(userResponse)
                .build();
    }

}
