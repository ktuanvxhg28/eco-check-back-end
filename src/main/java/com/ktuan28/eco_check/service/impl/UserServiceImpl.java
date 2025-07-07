package com.ktuan28.eco_check.service.impl;

import com.ktuan28.eco_check.dto.request.UserCreateRequest;
import com.ktuan28.eco_check.dto.response.UserResponse;
import com.ktuan28.eco_check.entity.User;
import com.ktuan28.eco_check.exception.AppException;
import com.ktuan28.eco_check.exception.ErrorCode;
import com.ktuan28.eco_check.mapper.UserMapper;
import com.ktuan28.eco_check.repository.UserRepository;
import com.ktuan28.eco_check.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserResponse createUser(UserCreateRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        String hasedPassword = passwordEncoder.encode(request.getPassword());

        User user = UserMapper.toEntity(request, hasedPassword);

        User saved = userRepository.save(user);

        return  UserMapper.toResponse(saved);
    }
}
