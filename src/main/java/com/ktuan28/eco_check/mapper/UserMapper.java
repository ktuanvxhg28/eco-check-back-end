package com.ktuan28.eco_check.mapper;

import com.ktuan28.eco_check.dto.request.UserCreateRequest;
import com.ktuan28.eco_check.dto.response.UserResponse;
import com.ktuan28.eco_check.entity.User;

public class UserMapper {
    // Map Vehicle entity => UserCreateResponse (trả về FE)
    public static UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }

        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setAddress(user.getAddress());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());

        return response;
    }

    // Map VehicleCreateRequest => Vehicle entity (khi tạo mới)
    public static User toEntity(UserCreateRequest request,String passwordEncoder) {
        if (request == null) {
            return null;
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder);
        user.setFullName(request.getFullName());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());
        return user;
    }

}
